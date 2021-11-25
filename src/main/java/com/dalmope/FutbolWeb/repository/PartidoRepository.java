package com.dalmope.FutbolWeb.repository;

import com.dalmope.FutbolWeb.DTO.Partido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {    
}
