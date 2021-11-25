package com.dalmope.FutbolWeb.repository;

import java.util.List;

import com.dalmope.FutbolWeb.DTO.Jugador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    List<Jugador> findByIdEquipo(Integer Equipo);
}

