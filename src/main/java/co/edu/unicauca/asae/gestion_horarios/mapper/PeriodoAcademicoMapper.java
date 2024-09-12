package co.edu.unicauca.asae.gestion_horarios.mapper;

import co.edu.unicauca.asae.gestion_horarios.dto.PeriodoAcademicoDTO;
import co.edu.unicauca.asae.gestion_horarios.model.PeriodoAcademico;
import org.springframework.stereotype.Component;

@Component
public class PeriodoAcademicoMapper {

    public PeriodoAcademicoDTO toDTO(PeriodoAcademico periodoAcademico) {
        PeriodoAcademicoDTO dto = new PeriodoAcademicoDTO();
        dto.setId(periodoAcademico.getId());
        dto.setNombre(periodoAcademico.getNombre());
        dto.setFechaInicio(periodoAcademico.getFechaInicio());
        dto.setFechaFin(periodoAcademico.getFechaFin());
        return dto;
    }

    public PeriodoAcademico toEntity(PeriodoAcademicoDTO dto) {
        PeriodoAcademico periodoAcademico = new PeriodoAcademico();
        periodoAcademico.setId(dto.getId());
        periodoAcademico.setNombre(dto.getNombre());
        periodoAcademico.setFechaInicio(dto.getFechaInicio());
        periodoAcademico.setFechaFin(dto.getFechaFin());
        return periodoAcademico;
    }
}