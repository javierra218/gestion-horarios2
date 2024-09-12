package co.edu.unicauca.asae.gestion_horarios.dto;

import lombok.Data;
import java.time.LocalTime;

@Data
public class FranjaHorariaDTO {
    private Long id;
    private Long cursoId;
    private Long profesorId;
    private Long espacioFisicoId;
    private Long periodoAcademicoId;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}