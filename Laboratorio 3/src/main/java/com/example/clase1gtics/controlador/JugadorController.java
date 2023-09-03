package com.example.clase1gtics.controlador;

import com.example.clase1gtics.entidad.Jugador;
import com.example.clase1gtics.repositorio.JugadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jugador")

public class JugadorController {

    final JugadorRepository jugadorRepository;

    public JugadorController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    //LISTAMOS LOS JUGADORES, RECORDEMOS QUE LISTAR ES ÚNICAMENTE MÉTODO GET
    @GetMapping(value = {"", "/listar"})
    public String listar(Model model) {
        //CREAMOS UNA LISTA DE JUGADORES, LLAMADA listajugadores, y guardamos ahí a todos los jugadores que salgan
        //CON EL REPOSITORIO
        List<Jugador> listajugadores = jugadorRepository.findAll();
        //AHORA PONEMOS EL MODEL PARA MANDARLO A LA VISTA HTML:
        //GUARDAMOS NUESTRA LISTA QUE ACABAMOS DE CREAR "listajugadores" en nuestro variable "listajugadoreshtml"
        //ESTA ÚLTIMA ES LA QUE MANDAREMOS AL HTML
        model.addAttribute("listajugadoreshtml", listajugadores);
        return "jugador/list";
    }

    //HACEMOS UNA RUTA PARA LA CREACION DEL FORMULARIO
    @GetMapping("/new")
    public String crear() {
        //ESTO SOLO SIRVE PARA REGRESAR EL HTML CUANDO LE DAN A jugador/new
        return "jugador/newForm";
    }

    /*
    @PostMapping("/guardar")
    public String guardar(Jugador jugador) {
        String x = "hola";
        jugadorRepository.save(jugador);
        String y = "chau";
        return "redirect:/jugador/listar";
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {

        Optional<Jugador> optional = jugadorRepository.findById(id);

        if (optional.isPresent()) {
            jugadorRepository.deleteById(id);
        }

        return "redirect:/jugador/listar";
    }
     */



}
