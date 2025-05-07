package com.alkemy.java2.clase03.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import com.alkemy.java2.clase03.enums.TipoNotificacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
public class NotificacionDTO {

  private Long id;

  @NotNull(message = "La fecha no puede ser nula")
  private LocalDateTime fecha;

  private boolean leida;

  private LocalDateTime fechaLeida;

  @NotBlank(message = "El mensaje no puede estar vacío")
  private String mensaje;

  @NotNull(message = "El tipo de notificación es obligatorio")
  private TipoNotificacion tipo;

  @NotNull(message = "El ID del usuario no puede ser nulo")
  private Long userId;
}
