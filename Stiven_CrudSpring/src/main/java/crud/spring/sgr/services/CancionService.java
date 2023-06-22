package crud.spring.sgr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.spring.sgr.modelo.Cancion;
import crud.spring.sgr.repositorio.CancionRepositorio;

@Service
public class CancionService {
    @Autowired
    private CancionRepositorio cancionRepositorio;

    public List<Cancion> listarCanciones() {
        return cancionRepositorio.findAll();
    }

    public Optional<Cancion> obtenerCancionPorId(int id) {
        return cancionRepositorio.findById(id);
    }

    public Cancion guardarCancion(Cancion cancion) {
        return cancionRepositorio.save(cancion);
    }

    public void eliminarCancion(int id) {
        cancionRepositorio.deleteById(id);
    }
}
