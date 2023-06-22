package crud.spring.sgr.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import crud.spring.sgr.modelo.Usuario;
import crud.spring.sgr.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario/registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        try {
            usuarioService.guardarUsuario(usuario);
            model.addAttribute("mensaje", "Usuario registrado correctamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el usuario.");
        }
        return "Usuario/registrar";
    }

    @GetMapping("/listar")
    public String mostrarListaUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodosLosUsuarios());
        return "Usuario/listar";
    }

    @GetMapping("/editar/{cc}")
    public String mostrarFormularioEdicion(@PathVariable("cc") int cc, Model model) {
        Usuario usuario = usuarioService.obtenerUsuarioPorCc(cc)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con CC: " + cc));
        model.addAttribute("usuario", usuario);
        return "Usuario/editar";
    }

    @PostMapping("/editar/{cc}")
    public String editarUsuario(@PathVariable("cc") int cc, @ModelAttribute("usuario") Usuario usuario) {
        usuario.setCc(cc);
        usuarioService.actualizarUsuario(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/eliminar/{cc}")
    public String eliminarUsuario(@PathVariable("cc") int cc) {
        usuarioService.eliminarUsuario(cc);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Usuario/login";
    }

    @PostMapping("/login")
    public String loginUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        int cc = usuario.getCc();
        String pass = usuario.getPass();
        if (usuarioService.validarCredenciales(cc, pass)) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "Credenciales invÃ¡lidas.");
            return "Usuario/login";
        }
    }
}