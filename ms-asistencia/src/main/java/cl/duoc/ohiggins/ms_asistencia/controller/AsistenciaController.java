package cl.duoc.ohiggins.ms_asistencia.controller;

import cl.duoc.ohiggins.ms_asistencia.model.Asistencia;
import cl.duoc.ohiggins.ms_asistencia.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    // Registrar asistencia (Acción del profesor)
    @PostMapping
    public ResponseEntity<Asistencia> registrarAsistencia(@RequestBody Asistencia asistencia) {
        Asistencia nuevaAsistencia = asistenciaRepository.save(asistencia);
        return new ResponseEntity<>(nuevaAsistencia, HttpStatus.CREATED);
    }

    // Consultar asistencia (Acción del estudiante/apoderado)
    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<Asistencia>> obtenerAsistenciaEstudiante(@PathVariable Long id) {
        List<Asistencia> lista = asistenciaRepository.findByEstudianteId(id);
        return ResponseEntity.ok(lista);
    }
}