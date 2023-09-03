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

    @GetMapping(value = {"", "/listar"})
    public String listar(Model model) {
        List<Jugador> listajugadores = jugadorRepository.findAll();
        model.addAttribute("listajugadoreshtml", listajugadores);
        return "jugador/list";
    }

    /*
    @GetMapping("/new")
    public String crear() {
        return "jugador/newForm";
    }

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
