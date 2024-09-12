package co.edu.unicauca.asae.gestion_horarios.service;

import co.edu.unicauca.asae.gestion_horarios.model.Profesor;
import co.edu.unicauca.asae.gestion_horarios.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    public Profesor getProfesorById(Long id) {
        return profesorRepository.findById(id).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    public Profesor saveProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void deleteProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}
