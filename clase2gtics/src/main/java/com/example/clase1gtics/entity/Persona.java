package com.example.clase1gtics.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class Persona {
    private int id = new Random().nextInt();
    private String nombre;
    private String apellido;
    private String email = "a@a.com";
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
