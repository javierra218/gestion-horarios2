package co.edu.unicauca.asae.gestion_horarios.repository;

import co.edu.unicauca.asae.gestion_horarios.model.DiaSemana;
import co.edu.unicauca.asae.gestion_horarios.model.EspacioFisico;
import co.edu.unicauca.asae.gestion_horarios.model.FranjaHoraria;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FranjaHorariaRepository extends JpaRepository<FranjaHoraria, Long> {
    List<FranjaHoraria> findByEspacioFisicoAndDia(EspacioFisico espacioFisico, DiaSemana dia);
}