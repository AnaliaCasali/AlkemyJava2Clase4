package com.alkemy.java2.clase03.controller;

import com.alkemy.java2.clase03.dto.NotificacionDTO;
import com.alkemy.java2.clase03.service.NotificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
@Tag(name = "Notificaciones", description = "Operaciones relacionadas con notificaciones internas del sistema")
public class NotificacionController {

  private final NotificacionService notificacionService;

  @PostMapping
  @Operation(
      summary = "Crear una nueva notificación",
      description = "Crea una notificación válida y la guarda en el sistema"
  )
  @ApiResponse(responseCode = "201", description = "Notificación creada exitosamente")
  public ResponseEntity<NotificacionDTO> crear(@Valid @RequestBody NotificacionDTO dto) {
    NotificacionDTO creada = notificacionService.crear(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(creada);
  }

  @GetMapping
  @Operation(
      summary = "Obtener todas las notificaciones",
      description = "Devuelve una lista con todas las notificaciones del sistema"
  )
  public ResponseEntity<List<NotificacionDTO>> obtenerTodas() {
    List<NotificacionDTO> lista = notificacionService.obtenerTodas();
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/{id}")
  @Operation(
      summary = "Obtener una notificación por ID",
      description = "Busca una notificación específica por su ID"
  )
  @ApiResponse(responseCode = "200", description = "Notificación encontrada")
  @ApiResponse(responseCode = "404", description = "Notificación no encontrada")
  public ResponseEntity<NotificacionDTO> obtenerPorId(
      @Parameter(description = "ID de la notificación a buscar") @PathVariable Long id
  ) {
    try {
      NotificacionDTO notificacion = notificacionService.obtenerPorId(id);
      return ResponseEntity.ok(notificacion);
    } catch (RuntimeException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  @Operation(
      summary = "Eliminar una notificación",
      description = "Elimina una notificación existente por su ID"
  )
  @ApiResponse(responseCode = "204", description = "Notificación eliminada exitosamente")
  @ApiResponse(responseCode = "404", description = "Notificación no encontrada")
  public ResponseEntity<Void> eliminar(
      @Parameter(description = "ID de la notificación a eliminar") @PathVariable Long id
  ) {
    try {
      notificacionService.eliminar(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @GetMapping("/no-leidas/{userId}")
  @Operation(
      summary = "Obtener notificaciones no leídas por usuario",
      description = "Devuelve todas las notificaciones no leídas de un usuario específico"
  )
  public ResponseEntity<List<NotificacionDTO>> obtenerNoLeidas(
      @Parameter(description = "ID del usuario") @PathVariable Long userId
  ) {
    try {
      List<NotificacionDTO> lista = notificacionService.obtenerNoLeidasPorUsuario(userId);
      return ResponseEntity.ok(lista);
    } catch (RuntimeException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

}