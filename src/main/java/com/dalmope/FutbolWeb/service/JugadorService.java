package com.dalmope.FutbolWeb.service;

import java.util.List;

import com.dalmope.FutbolWeb.DTO.Jugador;
import com.dalmope.FutbolWeb.repository.JugadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JugadorService {
    
    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> findByEquipo(Integer id) {
        try {
            return jugadorRepository.findByIdEquipo(id);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

    public Jugador findById(Integer id) {
        try {
            return jugadorRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

    public Jugador save(Jugador jugador) {
        try {
            return jugadorRepository.save(jugador);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

    public void delete(Integer id) {
        try {
            jugadorRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public List<Jugador> findAll() {
        try {
            return jugadorRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }

}
