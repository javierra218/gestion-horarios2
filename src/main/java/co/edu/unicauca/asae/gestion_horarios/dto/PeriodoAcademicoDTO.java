package co.edu.unicauca.asae.gestion_horarios.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PeriodoAcademicoDTO {
    private Long id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}