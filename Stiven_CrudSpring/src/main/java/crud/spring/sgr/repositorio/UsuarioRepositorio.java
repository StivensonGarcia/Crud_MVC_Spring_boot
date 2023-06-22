package crud.spring.sgr.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.spring.sgr.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    Usuario findByCcAndPass(int cc, String pass);
}