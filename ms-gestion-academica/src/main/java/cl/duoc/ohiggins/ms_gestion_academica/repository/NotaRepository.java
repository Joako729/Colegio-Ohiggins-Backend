package cl.duoc.ohiggins.ms_gestion_academica.repository;

import cl.duoc.ohiggins.ms_gestion_academica.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

    // Método para que el estudiante vea solo SUS notas
    List<Nota> findByEstudianteId(Long estudianteId);
}