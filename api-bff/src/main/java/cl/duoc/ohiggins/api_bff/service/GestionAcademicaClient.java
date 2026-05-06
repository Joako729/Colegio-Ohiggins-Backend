package cl.duoc.ohiggins.api_bff.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GestionAcademicaClient {
    private final RestTemplate restTemplate = new RestTemplate();

    // IMPORTANTE: Asegúrate de que el puerto (8081) sea el de tu ms-gestion-academica
    private final String URL_MS = "http://localhost:8081/notas";

    public Object enviarNota(Object nota) {
        return restTemplate.postForObject(URL_MS + "/guardar", nota, Object.class);
    }

    public Object[] pedirNotas(String rut) {
        return restTemplate.getForObject(URL_MS + "/estudiante/" + rut, Object[].class);
    }
}