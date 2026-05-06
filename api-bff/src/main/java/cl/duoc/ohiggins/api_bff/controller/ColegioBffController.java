package cl.duoc.ohiggins.api_bff.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000") // Permite la conexión con tu frontend Next.js
@RestController
@RequestMapping("/api/bff")
public class ColegioBffController {

    private final RestTemplate restTemplate = new RestTemplate();

    // Direcciones de los microservicios (Puertos 8081 y 8082)[cite: 1, 3]
    private final String URL_NOTAS = "http://localhost:8081/api/notas";
    private final String URL_ASISTENCIA = "http://localhost:8082/api/asistencia";

    // --- SECCIÓN DE GESTIÓN ACADÉMICA (NOTAS) ---[cite: 2]

    @PostMapping("/notas/registrar")
    public ResponseEntity<Object> registrarNota(@RequestBody Object nota) {
        // Envía la nota al ms-gestion-academica
        Object respuesta = restTemplate.postForObject(URL_NOTAS, nota, Object.class);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/notas/estudiante/{rut}")
    public Object[] consultarNotas(@PathVariable String rut) {
        // Obtiene la lista de notas del ms-gestion-academica
        return restTemplate.getForObject(URL_NOTAS + "/estudiante/" + rut, Object[].class);
    }

    // --- SECCIÓN DE REGISTRO DE ASISTENCIA ---[cite: 2]

    @PostMapping("/asistencia/registrar")
    public ResponseEntity<Object> registrarAsistencia(@RequestBody Object asistencia) {
        // Envía la asistencia al ms-asistencia
        Object respuesta = restTemplate.postForObject(URL_ASISTENCIA + "/registrar", asistencia, Object.class);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/asistencia/estudiante/{rut}")
    public Object[] consultarAsistencia(@PathVariable String rut) {
        // Obtiene el historial de asistencia del ms-asistencia
        return restTemplate.getForObject(URL_ASISTENCIA + "/estudiante/" + rut, Object[].class);
    }
}