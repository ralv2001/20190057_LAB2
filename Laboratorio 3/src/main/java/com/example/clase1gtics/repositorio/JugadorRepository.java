package com.example.clase1gtics.repositorio;

import com.example.clase1gtics.entidad.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer>{




    //ESTO VA A INDICAR EL QUERY QUE QUEREMOS QUE HAGA NUESTRO MÉTODO
    //NOTAR QUE LOS %% SIGNIFICAN "BÚSQUEDA PARCIAL", ES DECIR, QUE SI EL CAMPO posicion DE LA BASE DE DATOS
    //CONTIENE ALGO QUE EL USUARIO INGRESÓ EN EL PARÁMETRO DE BUSQUEDA, ESTO SE VA A MOSTRAR
    //EJEMPLO: CAMPO DE BÚSQUEDA PINTU:
    //SI VA A MOSTRAR:
    //PINTURASA
    //PINTURACA
    //CREMA DE PINTURA
    //ARBOL PINTUREZCO
    //ESTO NO ES CASE SENSITIVE, es decir, puedo poner DEL o del o dEL si deseo
    @Query (value = "SELECT * FROM jugador where posicion like %?1% ORDER BY edad asc",
            nativeQuery = true)

    //ESTE ES UN MÉTODO AL CUAL TU LE VAS A PASAR UN CAMPO DE BÚSQUEDA posicionsita Y TE VA A LISTAR
    //A PARTIR DE ESE CAMPO
    List<Jugador> findByposicionsita (String posicionsita);
}

