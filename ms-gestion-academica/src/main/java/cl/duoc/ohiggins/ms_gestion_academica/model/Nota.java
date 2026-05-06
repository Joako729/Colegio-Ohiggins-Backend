package cl.duoc.ohiggins.ms_gestion_academica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rutEstudiante;
    private String asignatura;
    private Double valor;
}