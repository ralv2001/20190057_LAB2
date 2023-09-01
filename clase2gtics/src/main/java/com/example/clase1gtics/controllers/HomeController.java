package com.example.clase1gtics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String paginaPrincipal(){
        return "hola ciclo 2023-2 :D";
    }

    @RequestMapping(value = {"/empleado1","/employee1","/em1"})
    public String empleado(){
        return "pag1";
    }
}
