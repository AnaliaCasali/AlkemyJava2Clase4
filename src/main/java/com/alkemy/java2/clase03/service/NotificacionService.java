package com.alkemy.java2.clase03.service;


import com.alkemy.java2.clase03.dto.NotificacionDTO;

import java.util.List;

public interface NotificacionService {

  NotificacionDTO crear(NotificacionDTO dto);

  NotificacionDTO obtenerPorId(Long id);

  List<NotificacionDTO> obtenerTodas();

  NotificacionDTO actualizar(Long id, NotificacionDTO dto);

  void eliminar(Long id);

  List<NotificacionDTO> obtenerNoLeidasPorUsuario(Long userId);
}
