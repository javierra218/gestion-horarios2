package co.edu.unicauca.asae.gestion_horarios.mapper;

import co.edu.unicauca.asae.gestion_horarios.dto.CursoDTO;
import co.edu.unicauca.asae.gestion_horarios.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setCodigo(curso.getCodigo());
        return dto;
    }

    public Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNombre(dto.getNombre());
        curso.setCodigo(dto.getCodigo());
        return curso;
    }
}