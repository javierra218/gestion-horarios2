package co.edu.unicauca.asae.gestion_horarios.mapper;


import co.edu.unicauca.asae.gestion_horarios.dto.EspacioFisicoDTO;
import co.edu.unicauca.asae.gestion_horarios.model.EspacioFisico;
import org.springframework.stereotype.Component;
@Component
public class EspacioFisicoMapper {

    public EspacioFisicoDTO toDTO(EspacioFisico espacioFisico) {
        EspacioFisicoDTO dto = new EspacioFisicoDTO();
        dto.setId(espacioFisico.getId());
        dto.setNombre(espacioFisico.getNombre());
        dto.setTipo(espacioFisico.getTipo().name());
        dto.setCapacidad(espacioFisico.getCapacidad());
        return dto;
    }

    public EspacioFisico toEntity(EspacioFisicoDTO dto) {
        EspacioFisico espacioFisico = new EspacioFisico();
        espacioFisico.setId(dto.getId());
        espacioFisico.setNombre(dto.getNombre());
        espacioFisico.setTipo(TipoEspacio.valueOf(dto.getTipo()));
        espacioFisico.setCapacidad(dto.getCapacidad());
        return espacioFisico;
    }
}