package cl.duoc.ohiggins.ms_asistencia.controller;

import cl.duoc.ohiggins.ms_asistencia.model.Asistencia;
import cl.duoc.ohiggins.ms_asistencia.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository repository;

    @PostMapping("/registrar")
    public Asistencia registrarAsistencia(@RequestBody Asistencia asistencia) {
        // Si no mandan fecha, ponemos la del día de hoy automáticamente
        if (asistencia.getFecha() == null) {
            asistencia.setFecha(LocalDate.now());
        }
        return repository.save(asistencia);
    }

    @GetMapping("/estudiante/{rut}")
    public List<Asistencia> obtenerPorEstudiante(@PathVariable String rut) {
        return repository.findByRutEstudiante(rut);
    }
}