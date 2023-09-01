package com.example.clase1gtics.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeleccionRepository extends JpaRepository<Shipper, Integer> {
}
