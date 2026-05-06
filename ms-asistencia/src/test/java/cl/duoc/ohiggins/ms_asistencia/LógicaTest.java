package cl.duoc.ohiggins.ms_asistencia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LógicaTest {

    @Test
    void testCalculosAsistencia() {
        // Simulamos lógica de porcentaje de asistencia
        int clasesTotales = 20;
        int clasesAsistidas = 15;
        double porcentaje = (double) clasesAsistidas / clasesTotales * 100;

        assertTrue(porcentaje >= 75.0);
        assertEquals(75.0, porcentaje);
    }
}