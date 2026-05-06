package cl.duoc.ohiggins.ms_gestion_academica.repository;

import cl.duoc.ohiggins.ms_gestion_academica.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}