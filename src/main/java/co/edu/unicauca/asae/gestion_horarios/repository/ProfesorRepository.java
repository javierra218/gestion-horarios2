package co.edu.unicauca.asae.gestion_horarios.repository;

import co.edu.unicauca.asae.gestion_horarios.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
