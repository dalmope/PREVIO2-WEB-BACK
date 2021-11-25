package com.dalmope.FutbolWeb.service;

import java.util.List;

import com.dalmope.FutbolWeb.DTO.Equipo;
import com.dalmope.FutbolWeb.repository.EquipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipoService {
    
    @Autowired
    private EquipoRepository equipoRepository;

    public Equipo findByCodigo(Integer id) {
        try {
            return equipoRepository.findByCodigo(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

    public void save(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    public void delete(Equipo equipo) {
        equipoRepository.delete(equipo);
    }

    public void deleteById(Integer id) {
        equipoRepository.deleteById(id);
    }

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Boolean existsByCodigo(Integer codigo) {
        return equipoRepository.existsById(codigo);
    }

}
