package com.dalmope.FutbolWeb.repository;

import java.util.Optional;

import com.dalmope.FutbolWeb.DTO.Equipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    Boolean existsByNombre(String nombre);
    Boolean existsByCodigo(Integer codigo);
    Optional<Equipo> findByNombre(String nombre);
    Optional<Equipo> findByCodigo(Integer codigo);
}
    

