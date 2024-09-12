package co.edu.unicauca.asae.gestion_horarios.controller;

import co.edu.unicauca.asae.gestion_horarios.model.FranjaHoraria;
import co.edu.unicauca.asae.gestion_horarios.service.FranjaHorariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franjashorarias")
public class FranjaHorariaController {

    private final FranjaHorariaService franjaHorariaService;

    public FranjaHorariaController(FranjaHorariaService franjaHorariaService) {
        this.franjaHorariaService = franjaHorariaService;
    }

    @GetMapping
    public List<FranjaHoraria> getAllFranjaHorarias() {
        return franjaHorariaService.getAllFranjaHorarias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FranjaHoraria> getFranjaHorariaById(@PathVariable Long id) {
        return ResponseEntity.ok(franjaHorariaService.getFranjaHorariaById(id));
    }

    @PostMapping
    public ResponseEntity<FranjaHoraria> createFranjaHoraria(@RequestBody FranjaHoraria franjaHoraria) {
        return ResponseEntity.ok(franjaHorariaService.saveFranjaHoraria(franjaHoraria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFranjaHoraria(@PathVariable Long id) {
        franjaHorariaService.deleteFranjaHoraria(id);
        return ResponseEntity.noContent().build();
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<FranjaHoraria> updateFranjaHoraria(@PathVariable Long id, @RequestBody FranjaHoraria franjaHoraria) {
        franjaHoraria.setId(id);
        return ResponseEntity.ok(franjaHorariaService.saveFranjaHoraria(franjaHoraria));
    }

}
