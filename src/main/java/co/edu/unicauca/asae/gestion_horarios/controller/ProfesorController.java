package co.edu.unicauca.asae.gestion_horarios.controller;

import co.edu.unicauca.asae.gestion_horarios.model.Profesor;
import co.edu.unicauca.asae.gestion_horarios.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public List<Profesor> getAllProfesores() {
        return profesorService.getAllProfesores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable Long id) {
        return ResponseEntity.ok(profesorService.getProfesorById(id));
    }

    @PostMapping
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.saveProfesor(profesor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        profesorService.deleteProfesor(id);
        return ResponseEntity.noContent().build();
    }
}
