package crud.spring.sgr.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import crud.spring.sgr.modelo.Cancion;
import crud.spring.sgr.services.CancionService;

@Controller
@RequestMapping("/canciones")
public class CancionController {
    @Autowired
    private CancionService cancionServicio;
    
    @GetMapping("/listar")
    public String listarCanciones(Model model) {
        List<Cancion> canciones = cancionServicio.listarCanciones();
        model.addAttribute("canciones", canciones);
        return "Canciones/listar";
    }
    
    @GetMapping("/agregar")
    public String mostrarFormularioAgregarCancion(Model model) {
        Cancion cancion = new Cancion();
        model.addAttribute("cancion", cancion);
        return "Canciones/agregar";
    }
    
    @PostMapping("/agregar")
    public String agregarCancion(@ModelAttribute("cancion") Cancion cancion) {
        cancionServicio.guardarCancion(cancion);
        return "redirect:/canciones/agregar";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCancion(@PathVariable("id") int id, Model model) {
        Optional<Cancion> cancion = cancionServicio.obtenerCancionPorId(id);
        if (cancion.isPresent()) {
            model.addAttribute("cancion", cancion.get());
        } else {
            model.addAttribute("error", "La cancion no existe");
        }
        return "Canciones/editar";
    }
    
    @PostMapping("/editar/{id}")
    public String editarCancion(@PathVariable("id") int id, @ModelAttribute("cancion") Cancion cancion) {
        cancionServicio.guardarCancion(cancion);
        return "redirect:/canciones/listar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarCancion(@PathVariable("id") int id) {
        cancionServicio.eliminarCancion(id);
        return "redirect:/canciones/listar";
    }
}