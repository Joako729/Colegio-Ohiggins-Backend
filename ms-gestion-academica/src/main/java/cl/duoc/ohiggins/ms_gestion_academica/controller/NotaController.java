package cl.duoc.ohiggins.ms_gestion_academica.controller;

import cl.duoc.ohiggins.ms_gestion_academica.model.Nota;
import cl.duoc.ohiggins.ms_gestion_academica.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaRepository repository;

    @PostMapping
    public Nota guardar(@RequestBody Nota nota) {
        return repository.save(nota);
    }

    @GetMapping("/estudiante/{rut}")
    public List<Nota> obtenerPorEstudiante(@PathVariable String rut) {
        return repository.findByRutEstudiante(rut);
    }
}