package cl.duoc.ohiggins.ms_gestion_academica.controller;

import cl.duoc.ohiggins.ms_gestion_academica.model.Nota;
import cl.duoc.ohiggins.ms_gestion_academica.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    // Acción del PROFESOR: Registrar una nueva nota
    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
        Nota nuevaNota = notaRepository.save(nota);
        return new ResponseEntity<>(nuevaNota, HttpStatus.CREATED);
    }

    // Acción del ESTUDIANTE: Ver todas sus notas
    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<Nota>> obtenerNotasEstudiante(@PathVariable Long id) {
        List<Nota> notas = notaRepository.findByEstudianteId(id);
        return ResponseEntity.ok(notas);
    }
}