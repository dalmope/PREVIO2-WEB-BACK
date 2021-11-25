package com.dalmope.FutbolWeb.controller;

import java.util.List;

import com.dalmope.FutbolWeb.DTO.Jugador;
import com.dalmope.FutbolWeb.DTO.Mensaje;
import com.dalmope.FutbolWeb.service.JugadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/jugador")
@CrossOrigin(origins = "*")
public class JugadorController {
    
    @Autowired
    private JugadorService jugadorService;

    @ApiOperation("Devuelve un listado de jugadores")
    @GetMapping
    public List<Jugador> getJugadores() {
        return jugadorService.findAll();
    }

    @ApiOperation("Devuelve un listado de jugadores por equipo")
    @GetMapping("/equipo/{codigoEquipo}")
    public ResponseEntity<?> getJugadoresByEquipo(@PathVariable("codigoEquipo") Integer codigoEquipo) {
        if (jugadorService.findByEquipo(codigoEquipo) == null) {
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        List<Jugador> jugador = jugadorService.findByEquipo(codigoEquipo);
        return new ResponseEntity<>(jugador, HttpStatus.OK);
    }

    @ApiOperation("Devuelve un jugador por su código")
    @GetMapping("/{id}")
    public Jugador getJugador(@PathVariable("id") Integer id) {
        return jugadorService.findById(id);
    }

}
