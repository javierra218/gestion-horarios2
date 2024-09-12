package co.edu.unicauca.asae.gestion_horarios.service;

import co.edu.unicauca.asae.gestion_horarios.model.EspacioFisico;
import co.edu.unicauca.asae.gestion_horarios.repository.EspacioFisicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacioFisicoService {

    private final EspacioFisicoRepository espacioFisicoRepository;

    public EspacioFisicoService(EspacioFisicoRepository espacioFisicoRepository) {
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    public List<EspacioFisico> getAllEspaciosFisicos() {
        return espacioFisicoRepository.findAll();
    }

    public EspacioFisico getEspacioFisicoById(Long id) {
        return espacioFisicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Espacio físico no encontrado"));
    }

    public EspacioFisico saveEspacioFisico(EspacioFisico espacioFisico) {
        return espacioFisicoRepository.save(espacioFisico);
    }

    public void deleteEspacioFisico(Long id) {
        espacioFisicoRepository.deleteById(id);
    }
}
