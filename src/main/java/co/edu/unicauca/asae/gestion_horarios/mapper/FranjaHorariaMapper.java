package co.edu.unicauca.asae.gestion_horarios.mapper;

import co.edu.unicauca.asae.gestion_horarios.dto.FranjaHorariaDTO;
import co.edu.unicauca.asae.gestion_horarios.model.*;
import co.edu.unicauca.asae.gestion_horarios.repository.*;
import org.springframework.stereotype.Component;

@Component
public class FranjaHorariaMapper {

    private final CursoRepository cursoRepository;
    private final ProfesorRepository profesorRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;
    private final PeriodoAcademicoRepository periodoAcademicoRepository;

    public FranjaHorariaMapper(CursoRepository cursoRepository,
                               ProfesorRepository profesorRepository,
                               EspacioFisicoRepository espacioFisicoRepository,
                               PeriodoAcademicoRepository periodoAcademicoRepository) {
        this.cursoRepository = cursoRepository;
        this.profesorRepository = profesorRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.periodoAcademicoRepository = periodoAcademicoRepository;
    }

    public FranjaHorariaDTO toDTO(FranjaHoraria franjaHoraria) {
        FranjaHorariaDTO dto = new FranjaHorariaDTO();
        dto.setId(franjaHoraria.getId());
        dto.setCursoId(franjaHoraria.getCurso().getId());
        dto.setProfesorId(franjaHoraria.getProfesor().getId());
        dto.setEspacioFisicoId(franjaHoraria.getEspacioFisico().getId());
        dto.setPeriodoAcademicoId(franjaHoraria.getPeriodoAcademico().getId());
        dto.setDia(franjaHoraria.getDia().name());
        dto.setHoraInicio(franjaHoraria.getHoraInicio());
        dto.setHoraFin(franjaHoraria.getHoraFin());
        return dto;
    }

    public FranjaHoraria toEntity(FranjaHorariaDTO dto) {
        FranjaHoraria franjaHoraria = new FranjaHoraria();
        franjaHoraria.setId(dto.getId());

        // Buscar y establecer el curso
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        franjaHoraria.setCurso(curso);

        // Buscar y establecer el profesor
        Profesor profesor = profesorRepository.findById(dto.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        franjaHoraria.setProfesor(profesor);

        // Buscar y establecer el espacio físico
        EspacioFisico espacioFisico = espacioFisicoRepository.findById(dto.getEspacioFisicoId())
                .orElseThrow(() -> new RuntimeException("Espacio físico no encontrado"));
        franjaHoraria.setEspacioFisico(espacioFisico);

        // Buscar y establecer el periodo académico
        PeriodoAcademico periodoAcademico = periodoAcademicoRepository.findById(dto.getPeriodoAcademicoId())
                .orElseThrow(() -> new RuntimeException("Periodo académico no encontrado"));
        franjaHoraria.setPeriodoAcademico(periodoAcademico);

        // Asignar el día, hora de inicio y fin
        franjaHoraria.setDia(DiaSemana.valueOf(dto.getDia()));
        franjaHoraria.setHoraInicio(dto.getHoraInicio());
        franjaHoraria.setHoraFin(dto.getHoraFin());

        return franjaHoraria;
    }
}