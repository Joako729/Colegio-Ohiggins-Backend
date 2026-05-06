package cl.duoc.ohiggins.api_bff.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bff")
public class ColegioBffController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String MS_URL = "http://localhost:8081/api/notas";

    @PostMapping("/notas/registrar")
    public ResponseEntity<Object> profesorRegistraNota(@RequestBody Object nota) {
        Object respuesta = restTemplate.postForObject(MS_URL, nota, Object.class);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/notas/estudiante/{rut}")
    public Object[] estudianteConsultaNotas(@PathVariable String rut) {
        return restTemplate.getForObject(MS_URL + "/estudiante/" + rut, Object[].class);
    }
}