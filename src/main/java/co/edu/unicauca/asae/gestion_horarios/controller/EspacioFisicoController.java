package co.edu.unicauca.asae.gestion_horarios.controller;

import co.edu.unicauca.asae.gestion_horarios.model.EspacioFisico;
import co.edu.unicauca.asae.gestion_horarios.service.EspacioFisicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espaciosfisicos")
public class EspacioFisicoController {

    private final EspacioFisicoService espacioFisicoService;

    public EspacioFisicoController(EspacioFisicoService espacioFisicoService) {
        this.espacioFisicoService = espacioFisicoService;
    }

    @GetMapping
    public List<EspacioFisico> getAllEspaciosFisicos() {
        return espacioFisicoService.getAllEspaciosFisicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspacioFisico> getEspacioFisicoById(@PathVariable Long id) {
        return ResponseEntity.ok(espacioFisicoService.getEspacioFisicoById(id));
    }

    @PostMapping
    public ResponseEntity<EspacioFisico> createEspacioFisico(@RequestBody EspacioFisico espacioFisico) {
        return ResponseEntity.ok(espacioFisicoService.saveEspacioFisico(espacioFisico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspacioFisico(@PathVariable Long id) {
        espacioFisicoService.deleteEspacioFisico(id);
        return ResponseEntity.noContent().build();
    }
}
