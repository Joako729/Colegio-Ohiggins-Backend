package cl.duoc.ohiggins.ms_gestion_academica.controller;

import cl.duoc.ohiggins.ms_gestion_academica.model.Asignatura;
import cl.duoc.ohiggins.ms_gestion_academica.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaRepository repository;

    @GetMapping
    public List<Asignatura> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Asignatura crear(@RequestBody Asignatura asignatura) {
        return repository.save(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura actualizar(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        asignatura.setId(id);
        return repository.save(asignatura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}