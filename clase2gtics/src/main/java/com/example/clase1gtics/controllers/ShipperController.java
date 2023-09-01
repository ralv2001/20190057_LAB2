package com.example.clase1gtics.controllers;

import com.example.clase1gtics.entity.Shipper;
import com.example.clase1gtics.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shipper")
public class ShipperController {

    final ShipperRepository shipperRepository;

    public ShipperController(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @GetMapping(value = {"", "/listar"})
    public String listar(Model model) {
        model.addAttribute("lista", shipperRepository.findAll());
        return "shipper/lista";
    }

    @GetMapping("/new")
    public String crear() {
        return "shipper/newform";
    }

    @PostMapping("/guardar")
    public String guardar(Shipper shipper) {
        String x = "hola";
        shipperRepository.save(shipper);
        String y = "chau";
        return "redirect:/shipper/listar";
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {

        Optional<Shipper> optional = shipperRepository.findById(id);

        if (optional.isPresent()) {
            shipperRepository.deleteById(id);
        }

        return "redirect:/shipper/listar";
    }

    @GetMapping("/editar")
    public String formEditar(@RequestParam("id") int id, Model model) {

        Optional<Shipper> optional = shipperRepository.findById(id);

        if(optional.isPresent()){ //existe un shipper con ese ID
            Shipper shipper = optional.get();
            model.addAttribute("shipper",shipper);
            return "shipper/editForm";
        }else{
            return "redirect:/shipper/listar";
        }
    }
}
