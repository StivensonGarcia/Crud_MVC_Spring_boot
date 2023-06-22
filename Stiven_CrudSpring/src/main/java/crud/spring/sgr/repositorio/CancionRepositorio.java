package crud.spring.sgr.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import crud.spring.sgr.modelo.Cancion;

public interface CancionRepositorio extends JpaRepository<Cancion, Integer> {
}
