package com.example.clase1gtics.controlador;

import com.example.clase1gtics.entidad.Estadio;
import com.example.clase1gtics.repositorio.EstadioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/estadio")
public class EstadioController {

    final EstadioRepository estadioRepository;

    public EstadioController(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    //LISTAMOS LOS JUGADORES, RECORDEMOS QUE LISTAR ES ÚNICAMENTE MÉTODO GET
    @GetMapping(value = {"", "/listar"})
    public String listar(Model model) {
        //CREAMOS UNA LISTA DE JUGADORES, LLAMADA listajugadores, y guardamos ahí a todos los jugadores que salgan
        //CON EL REPOSITORIO
        List<Estadio> listaestadios = estadioRepository.findAll();
        //AHORA PONEMOS EL MODEL PARA MANDARLO A LA VISTA HTML:
        //GUARDAMOS NUESTRA LISTA QUE ACABAMOS DE CREAR "listajugadores" en nuestro variable "listajugadoreshtml"
        //ESTA ÚLTIMA ES LA QUE MANDAREMOS AL HTML
        model.addAttribute("listaestadioshtml", listaestadios);
        return "estadio/list";
    }
}
