package com.alkemy.java2.clase03.model;

import com.alkemy.java2.clase03.enums.TipoNotificacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

  @Builder
  @Entity
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime fecha;

    private boolean leida = false;

    private LocalDateTime fechaLeida;

    @NotBlank
    @Column(length = 1000)
    private String mensaje;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "No deberia ser nulo")
    private TipoNotificacion tipo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id") // según  PK de user
    private User user;
  }


