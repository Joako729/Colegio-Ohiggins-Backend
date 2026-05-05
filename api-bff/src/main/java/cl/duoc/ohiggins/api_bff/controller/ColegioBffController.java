package cl.duoc.ohiggins.api_bff.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/bff")
@CrossOrigin(origins = "http://localhost:3000") // Conexión directa con tu Next.js
public class ColegioBffController {

    private final RestTemplate restTemplate = new RestTemplate();

    // --- ACCIÓN DEL PROFESOR ---
    @PostMapping("/notas/registrar")
    public ResponseEntity<Object> profesorRegistraNota(@RequestBody Object nota) {
        // El BFF recibe la nota del profe y la manda al ms-gestion-academica (8081)
        String url = "http://localhost:8081/api/notas";
        Object respuesta = restTemplate.postForObject(url, nota, Object.class);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/asistencia/registrar")
    public ResponseEntity<Object> profesorRegistraAsistencia(@RequestBody Object asistencia) {
        // El BFF manda la asistencia al ms-asistencia (8082)
        String url = "http://localhost:8082/api/asistencia";
        Object respuesta = restTemplate.postForObject(url, asistencia, Object.class);
        return ResponseEntity.ok(respuesta);
    }

    // --- ACCIÓN DEL ESTUDIANTE (DASHBOARD) ---
    @GetMapping("/estudiante/{id}/resumen")
    public ResponseEntity<Map<String, Object>> estudianteVeSuLibro(@PathVariable Long id) {
        Map<String, Object> resumen = new HashMap<>();

        // 1. Pide las notas al microservicio 8081
        Object notas = restTemplate.getForObject("http://localhost:8081/api/notas/estudiante/" + id, Object.class);

        // 2. Pide la asistencia al microservicio 8082
        Object asistencia = restTemplate.getForObject("http://localhost:8082/api/asistencia/estudiante/" + id, Object.class);

        resumen.put("idEstudiante", id);
        resumen.put("notas", notas);
        resumen.put("asistencia", asistencia);

        return ResponseEntity.ok(resumen);
    }
}