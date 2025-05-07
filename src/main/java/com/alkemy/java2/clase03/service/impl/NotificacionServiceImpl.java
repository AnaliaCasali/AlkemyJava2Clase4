package com.alkemy.java2.clase03.service.impl;


import com.alkemy.java2.clase03.dto.NotificacionDTO;
import com.alkemy.java2.clase03.mapper.NotificacionMapper;
import com.alkemy.java2.clase03.model.Notificacion;
import com.alkemy.java2.clase03.model.User;
import com.alkemy.java2.clase03.repository.NotificacionRepository;
import com.alkemy.java2.clase03.repository.UserRepository;
import com.alkemy.java2.clase03.service.NotificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificacionServiceImpl implements NotificacionService {

  private final NotificacionRepository notificacionRepository;
  private final UserRepository userRepository;
  private final NotificacionMapper notificacionMapper;

  @Override
  public NotificacionDTO crear(NotificacionDTO dto) {
    Notificacion entidad = notificacionMapper.toEntity(dto);
    entidad.setFecha(LocalDateTime.now());

    User user = userRepository.findById(dto.getUserId())
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    entidad.setUser(user);

    return notificacionMapper.toDto(notificacionRepository.save(entidad));
  }

  @Override
  public NotificacionDTO obtenerPorId(Long id) {
    Notificacion notificacion = notificacionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
    return notificacionMapper.toDto(notificacion);
  }

  @Override
  public List<NotificacionDTO> obtenerTodas() {
    return notificacionRepository.findAll().stream()
        .map(notificacionMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public NotificacionDTO actualizar(Long id, NotificacionDTO dto) {
    Notificacion existente = notificacionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));

    existente.setMensaje(dto.getMensaje());
    existente.setTipo(dto.getTipo());
    existente.setLeida(dto.isLeida());
    existente.setFechaLeida(dto.isLeida() ? LocalDateTime.now() : null);

    return notificacionMapper.toDto(notificacionRepository.save(existente));
  }

  @Override
  public void eliminar(Long id) {
    if (!notificacionRepository.existsById(id)) {
      throw new RuntimeException("Notificación no encontrada");
    }
    notificacionRepository.deleteById(id);
  }

  @Override
  public List<NotificacionDTO> obtenerNoLeidasPorUsuario(Long userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    return notificacionRepository.buscarNoLeidasPorUsuario(user).stream()
        .map(notificacionMapper::toDto)
        .collect(Collectors.toList());
  }
}
