package com.dalmope.FutbolWeb.service;


import com.dalmope.FutbolWeb.DTO.Partido;
import com.dalmope.FutbolWeb.repository.PartidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public Partido findById(Integer id) {
        return partidoRepository.findById(id).get();
    }

    public void save(Partido partido) {
        partidoRepository.save(partido);
    }

    public void delete(Partido partido) {
        partidoRepository.delete(partido);
    }

    public void deleteById(Integer id) {
        partidoRepository.deleteById(id);
    }

    public Iterable<Partido> findAll() {
        return partidoRepository.findAll();
    }

}
