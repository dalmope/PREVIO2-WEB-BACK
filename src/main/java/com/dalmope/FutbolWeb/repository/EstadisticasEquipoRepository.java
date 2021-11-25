package com.dalmope.FutbolWeb.repository;

import com.dalmope.FutbolWeb.DTO.EstadisticasEquipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasEquipoRepository extends JpaRepository<EstadisticasEquipo, Integer> {
}

