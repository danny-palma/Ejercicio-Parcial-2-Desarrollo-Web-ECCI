package backend1.com.bachend1.datos.repositorios;

import backend1.com.bachend1.datos.entidades.Alumno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioAlumnos extends JpaRepository<Alumno, Integer>{
    @Query("SELECT a FROM Alumno a WHERE a.edad BETWEEN ?1 AND ?2")
    List<Alumno> findByEdadBetween(Integer desde, Integer hasta);
}
