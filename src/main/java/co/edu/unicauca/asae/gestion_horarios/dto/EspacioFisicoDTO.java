package co.edu.unicauca.asae.gestion_horarios.dto;

import lombok.Data;

@Data
public class EspacioFisicoDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private int capacidad;
}