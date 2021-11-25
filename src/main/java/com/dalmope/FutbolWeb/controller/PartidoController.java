package com.dalmope.FutbolWeb.controller;

import java.util.List;

import com.dalmope.FutbolWeb.DTO.Partido;
import com.dalmope.FutbolWeb.service.PartidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partido")
@CrossOrigin(origins = "*")
public class PartidoController {
    
    @Autowired
    private PartidoService partidoService;

    @GetMapping("/{id}")
    public Partido findById(@PathVariable("id") Integer id) {
        return partidoService.findById(id);
    }

    @GetMapping
    public List<Partido> list() {
        return (List<Partido>) partidoService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Partido partido) {
        partidoService.save(partido);
    }

    @DeleteMapping
    public void delete(@RequestBody Partido partido) {
        partidoService.delete(partido);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        partidoService.deleteById(id);
    }

}
