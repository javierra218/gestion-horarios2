package co.edu.unicauca.asae.gestion_horarios.service;

import co.edu.unicauca.asae.gestion_horarios.exception.BadRequestException;
import co.edu.unicauca.asae.gestion_horarios.exception.ResourceNotFoundException;
import co.edu.unicauca.asae.gestion_horarios.model.FranjaHoraria;
import co.edu.unicauca.asae.gestion_horarios.repository.FranjaHorariaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class FranjaHorariaService {

    private final FranjaHorariaRepository franjaHorariaRepository;

    public FranjaHorariaService(FranjaHorariaRepository franjaHorariaRepository) {
        this.franjaHorariaRepository = franjaHorariaRepository;
    }

    public List<FranjaHoraria> getAllFranjaHorarias() {
        return franjaHorariaRepository.findAll();
    }

    public FranjaHoraria getFranjaHorariaById(Long id) {
        return franjaHorariaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Franja horaria con ID " + id + " no encontrada"));
    }

    public FranjaHoraria saveFranjaHoraria(FranjaHoraria franjaHoraria) {
        // Verificar solapamiento de franjas horarias
        if (isSolapamiento(franjaHoraria)) {
            throw new BadRequestException("Solapamiento de franjas horarias detectado para el espacio " +
                    franjaHoraria.getEspacioFisico().getNombre() + " en el día " + franjaHoraria.getDia());
        }

        return franjaHorariaRepository.save(franjaHoraria);
    }

    public void deleteFranjaHoraria(Long id) {
        if (!franjaHorariaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Franja horaria con ID " + id + " no encontrada");
        }
        franjaHorariaRepository.deleteById(id);
    }

    private boolean isSolapamiento(FranjaHoraria nuevaFranja) {
        List<FranjaHoraria> franjasExistentes = franjaHorariaRepository.findByEspacioFisicoAndDia(
                nuevaFranja.getEspacioFisico(), nuevaFranja.getDia());

        for (FranjaHoraria franjaExistente : franjasExistentes) {
            LocalTime inicioExistente = franjaExistente.getHoraInicio();
            LocalTime finExistente = franjaExistente.getHoraFin();
            LocalTime inicioNueva = nuevaFranja.getHoraInicio();
            LocalTime finNueva = nuevaFranja.getHoraFin();

            // Verificar solapamiento
            if (inicioNueva.isBefore(finExistente) && finNueva.isAfter(inicioExistente)) {
                return true;
            }
        }

        return false;
    }

    //update
    public FranjaHoraria updateFranjaHoraria(Long id, FranjaHoraria franjaHoraria) {
        FranjaHoraria franjaHorariaActual = getFranjaHorariaById(id);
        franjaHorariaActual.setCurso(franjaHoraria.getCurso());
        franjaHorariaActual.setProfesor(franjaHoraria.getProfesor());
        franjaHorariaActual.setEspacioFisico(franjaHoraria.getEspacioFisico());
        franjaHorariaActual.setPeriodoAcademico(franjaHoraria.getPeriodoAcademico());
        franjaHorariaActual.setDia(franjaHoraria.getDia());
        franjaHorariaActual.setHoraInicio(franjaHoraria.getHoraInicio());
        franjaHorariaActual.setHoraFin(franjaHoraria.getHoraFin());
        return saveFranjaHoraria(franjaHorariaActual);
    }
}