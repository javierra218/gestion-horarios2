package co.edu.unicauca.asae.gestion_horarios.service;

import co.edu.unicauca.asae.gestion_horarios.model.PeriodoAcademico;
import co.edu.unicauca.asae.gestion_horarios.repository.PeriodoAcademicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoAcademicoService {

    private final PeriodoAcademicoRepository periodoAcademicoRepository;

    public PeriodoAcademicoService(PeriodoAcademicoRepository periodoAcademicoRepository) {
        this.periodoAcademicoRepository = periodoAcademicoRepository;
    }

    public List<PeriodoAcademico> getAllPeriodosAcademicos() {
        return periodoAcademicoRepository.findAll();
    }

    public PeriodoAcademico getPeriodoAcademicoById(Long id) {
        return periodoAcademicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Periodo académico no encontrado"));
    }

    public PeriodoAcademico savePeriodoAcademico(PeriodoAcademico periodoAcademico) {
        return periodoAcademicoRepository.save(periodoAcademico);
    }

    public void deletePeriodoAcademico(Long id) {
        periodoAcademicoRepository.deleteById(id);
    }
}
