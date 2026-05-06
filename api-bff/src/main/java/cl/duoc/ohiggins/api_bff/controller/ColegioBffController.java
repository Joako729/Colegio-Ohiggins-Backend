package cl.duoc.ohiggins.api_bff.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bff")
public class ColegioBffController {

    private final RestTemplate restTemplate = new RestTemplate();

    // URLs de Microservicios (Asegúrate de que los puertos sean correctos)
    private final String URL_NOTAS = "http://localhost:8081/api/notas";
    private final String URL_ASIGNATURAS = "http://localhost:8081/api/asignaturas";
    private final String URL_ASISTENCIA = "http://localhost:8082/api/asistencia";

    // --- ENDPOINTS ASIGNATURAS ---
    @GetMapping("/asignaturas")
    public Object[] listarAsignaturas() {
        return restTemplate.getForObject(URL_ASIGNATURAS, Object[].class);
    }

    @PostMapping("/asignaturas")
    public ResponseEntity<Object> crearAsignatura(@RequestBody Object asignatura) {
        return ResponseEntity.ok(restTemplate.postForObject(URL_ASIGNATURAS, asignatura, Object.class));
    }

    @PutMapping("/asignaturas/{id}")
    public void actualizarAsignatura(@PathVariable Long id, @RequestBody Object asignatura) {
        restTemplate.put(URL_ASIGNATURAS + "/" + id, asignatura);
    }

    @DeleteMapping("/asignaturas/{id}")
    public void eliminarAsignatura(@PathVariable Long id) {
        restTemplate.delete(URL_ASIGNATURAS + "/" + id);
    }

    // --- ENDPOINTS NOTAS ---
    @PostMapping("/notas/registrar")
    public ResponseEntity<Object> registrarNota(@RequestBody Object nota) {
        return ResponseEntity.ok(restTemplate.postForObject(URL_NOTAS, nota, Object.class));
    }

    @GetMapping("/notas/estudiante/{rut}")
    public Object[] consultarNotas(@PathVariable String rut) {
        return restTemplate.getForObject(URL_NOTAS + "/estudiante/" + rut, Object[].class);
    }

    // --- ENDPOINTS ASISTENCIA ---
    @PostMapping("/asistencia/registrar")
    public ResponseEntity<Object> registrarAsistencia(@RequestBody Object asistencia) {
        return ResponseEntity.ok(restTemplate.postForObject(URL_ASISTENCIA + "/registrar", asistencia, Object.class));
    }

    @GetMapping("/asistencia/estudiante/{rut}")
    public Object[] consultarAsistencia(@PathVariable String rut) {
        return restTemplate.getForObject(URL_ASISTENCIA + "/estudiante/" + rut, Object[].class);
    }
}