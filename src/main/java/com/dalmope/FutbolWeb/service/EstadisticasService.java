package com.dalmope.FutbolWeb.service;

import com.dalmope.FutbolWeb.DTO.EstadisticasEquipo;
import com.dalmope.FutbolWeb.repository.EstadisticasEquipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstadisticasService {
    
    @Autowired
    private EstadisticasEquipoRepository estadisticasRepository;

    public void save(EstadisticasEquipo estadisticas) {
        estadisticasRepository.save(estadisticas);
    }

    public EstadisticasEquipo findById(Integer id) {
        return estadisticasRepository.findById(id).get();
    }

    public Iterable<EstadisticasEquipo> findAll() {
        return estadisticasRepository.findAll();
    }

    public void delete(Integer id) {
        estadisticasRepository.deleteById(id);
    }

    public void delete(EstadisticasEquipo estadisticas) {
        estadisticasRepository.delete(estadisticas);
    }

    
}
