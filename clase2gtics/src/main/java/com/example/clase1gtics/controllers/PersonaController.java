package com.example.clase1gtics.controllers;

import com.example.clase1gtics.entity.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/persona")
public class PersonaController {

    @GetMapping("")
    public String form() {
        return "persona/form2";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona, @RequestParam("libro") String libro,
                          @RequestParam("edadStr") String edadStr) {
        //guardar en bd
        System.out.println("nombre recibido: " + persona.getNombre());
        System.out.println("edad recibida: " + persona.getEdad());
        System.out.println("libro recibido: " + libro);
        try{
            int edad = Integer.parseInt(edadStr);
            persona.setEdad(edad);
        }catch (NumberFormatException e){
            persona.setEdad(-1);
        }
        return "persona/success";
    }

    @GetMapping("/personaCompleta")
    public String abrirForm(Model model) {

        Persona persona = new Persona();
        persona.setNombre("Pedro");
        persona.setApellido("Perez");

        model.addAttribute("persona", persona);
        model.addAttribute("correo", "pedro.perez@ppp.com");


        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Sebastian", "Fuentes"));
        lista.add(new Persona("Diego", "Corcuera"));
        lista.add(new Persona("Pablo", "Florez"));

        model.addAttribute("lista", lista);

        return "persona/form2";
    }


}
