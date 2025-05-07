package com.alkemy.java2.clase03.repository;

import com.alkemy.java2.clase03.model.Notificacion;
import com.alkemy.java2.clase03.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

  // Consulta usando nombre de método
  List<Notificacion> findByUserAndLeidaFalse(User user);

  // Alternativa con @Query si preferís JPQL
  @Query("SELECT n FROM Notificacion n WHERE n.user = :user AND n.leida = false")
  List<Notificacion> buscarNoLeidasPorUsuario(User user);
}