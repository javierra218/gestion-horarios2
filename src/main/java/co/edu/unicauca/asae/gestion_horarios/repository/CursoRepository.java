package co.edu.unicauca.asae.gestion_horarios.repository;

import co.edu.unicauca.asae.gestion_horarios.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
