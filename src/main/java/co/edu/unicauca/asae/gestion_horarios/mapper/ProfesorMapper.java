package co.edu.unicauca.asae.gestion_horarios.mapper;

import co.edu.unicauca.asae.gestion_horarios.dto.ProfesorDTO;
import co.edu.unicauca.asae.gestion_horarios.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {

    public ProfesorDTO toDTO(Profesor profesor) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(profesor.getId());
        dto.setNombre(profesor.getNombre());
        dto.setApellido(profesor.getApellido());
        dto.setEmail(profesor.getEmail());
        return dto;
    }

    public Profesor toEntity(ProfesorDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setId(dto.getId());
        profesor.setNombre(dto.getNombre());
        profesor.setApellido(dto.getApellido());
        profesor.setEmail(dto.getEmail());
        return profesor;
    }
}