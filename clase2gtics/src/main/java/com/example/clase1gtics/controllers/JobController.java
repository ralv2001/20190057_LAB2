package com.example.clase1gtics.controllers;

import com.example.clase1gtics.entity.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/job")
public class JobController {

    //  /job
    @GetMapping(value = "")
    public String listar() {
        return "job/lista";
    }

    //  /job/buscar?id=[id]&nombre=[nom]&apellido=[ap]
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "apellido", required = false) String ape,
                         @RequestParam(name = "id", required = false) Integer id,
                         @RequestParam("nombre") String nombre) {
        System.out.println("nombre recibido: " + nombre);
        System.out.println("apellido recibido: " + ape);
        System.out.println("id recibido: " + id);
        return "job/lista";
    }

    //  /job/buscarF2/[id]/[nombre]/[apellido]
    @GetMapping("/buscarF2/{id}/{nombre}/{apellido}")
    public String buscarF2(@PathVariable("id") String id,
                           @PathVariable("nombre") String nombre,
                           @RequestParam("dni") String dni) {
        System.out.println("nombre recibido: " + nombre);
        System.out.println("id recibido: " + id);
        System.out.println("dni recibido: " + dni);
        return "job/lista";
    }

    //   /job/guardar
    @PostMapping("/guardar")
    public String guardar(Model model,
                          @RequestParam("id") Integer id,
                          @RequestParam("nombre") String nombre) {
        System.out.println("nombre recibido: " + nombre);
        System.out.println("id recibido: " + id);
        model.addAttribute("id",id);
        model.addAttribute("nombre",nombre);
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setApellido("Perez");
        model.addAttribute("persona",p);
        return "job/datos";
    }

    //job/crearform
    @GetMapping("/crearform")
    public String crear() {
        return "job/newJob";
    }

}
