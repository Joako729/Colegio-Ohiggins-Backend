package cl.duoc.ohiggins.ms_asistencia.repository;

import cl.duoc.ohiggins.ms_asistencia.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    // Para buscar el historial de asistencia de un alumno específico
    List<Asistencia> findByEstudianteId(Long estudianteId);
}