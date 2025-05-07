package com.alkemy.java2.clase03.mapper;


import com.alkemy.java2.clase03.dto.NotificacionDTO;
import com.alkemy.java2.clase03.model.Notificacion;
import com.alkemy.java2.clase03.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacionMapper {

  NotificacionMapper INSTANCE = Mappers.getMapper(NotificacionMapper.class);

  @Mapping(source = "user.id", target = "userId")
  NotificacionDTO toDto(Notificacion notificacion);

  @Mapping(source = "userId", target = "user.id")
  Notificacion toEntity(NotificacionDTO dto);

}
