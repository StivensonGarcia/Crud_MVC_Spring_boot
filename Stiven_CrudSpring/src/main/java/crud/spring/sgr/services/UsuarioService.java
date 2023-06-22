package crud.spring.sgr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crud.spring.sgr.modelo.Usuario;
import crud.spring.sgr.repositorio.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorCc(int cc) {
        return usuarioRepositorio.findById(cc);
    }

    public void guardarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(int cc) {
        usuarioRepositorio.deleteById(cc);
    }

    public boolean validarCredenciales(int cc, String pass) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(cc);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return usuario.getPass().equals(pass);
        }
        return false;
    }
}