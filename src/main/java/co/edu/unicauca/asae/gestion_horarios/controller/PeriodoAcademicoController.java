package co.edu.unicauca.asae.gestion_horarios.controller;

import co.edu.unicauca.asae.gestion_horarios.model.PeriodoAcademico;
import co.edu.unicauca.asae.gestion_horarios.service.PeriodoAcademicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periodosacademicos")
public class PeriodoAcademicoController {

    private final PeriodoAcademicoService periodoAcademicoService;

    public PeriodoAcademicoController(PeriodoAcademicoService periodoAcademicoService) {
        this.periodoAcademicoService = periodoAcademicoService;
    }

    @GetMapping
    public List<PeriodoAcademico> getAllPeriodosAcademicos() {
        return periodoAcademicoService.getAllPeriodosAcademicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoAcademico> getPeriodoAcademicoById(@PathVariable Long id) {
        return ResponseEntity.ok(periodoAcademicoService.getPeriodoAcademicoById(id));
    }

    @PostMapping
    public ResponseEntity<PeriodoAcademico> createPeriodoAcademico(@RequestBody PeriodoAcademico periodoAcademico) {
        return ResponseEntity.ok(periodoAcademicoService.savePeriodoAcademico(periodoAcademico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeriodoAcademico(@PathVariable Long id) {
        periodoAcademicoService.deletePeriodoAcademico(id);
        return ResponseEntity.noContent().build();
    }
}
