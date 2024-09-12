package co.edu.unicauca.asae.gestion_horarios.model;

import co.edu.unicauca.asae.gestion_horarios.mapper.TipoEspacio;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EspacioFisico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoEspacio tipo;

    private int capacidad;
}

