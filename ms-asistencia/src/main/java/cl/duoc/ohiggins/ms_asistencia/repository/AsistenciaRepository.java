package cl.duoc.ohiggins.ms_asistencia.repository;

import cl.duoc.ohiggins.ms_asistencia.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    // Permite buscar el historial de un alumno por su RUT
    List<Asistencia> findByRutEstudiante(String rutEstudiante);
}