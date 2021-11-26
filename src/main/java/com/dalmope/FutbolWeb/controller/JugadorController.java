package com.dalmope.FutbolWeb.controller;

import java.util.List;

import com.dalmope.FutbolWeb.DTO.Jugador;
import com.dalmope.FutbolWeb.DTO.Mensaje;
import com.dalmope.FutbolWeb.service.JugadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @ApiOperation("Crea un Jugador")
    @PostMapping
    public ResponseEntity<?> createJugador(@RequestBody Jugador jugador) {
        if (jugadorService.findById(jugador.getId()) != null) {
            return new ResponseEntity<>(new Mensaje("ya existe"), HttpStatus.CONFLICT);
        }
        jugadorService.save(jugador);
        return new ResponseEntity<>(new Mensaje("creado"), HttpStatus.CREATED);
    }

    @ApiOperation("Actualiza un Jugador")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateJugador(@PathVariable("id") Integer id, @RequestBody Jugador jugador) {
        if (jugadorService.findById(id) == null) {
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        jugador.setId(id);
        jugadorService.save(jugador);
        return new ResponseEntity<>(new Mensaje("actualizado"), HttpStatus.OK);
    }
    
    @ApiOperation("Borra un Jugador por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJugador(@PathVariable("id") Integer id) {
        if (jugadorService.findById(id) == null) {
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        jugadorService.delete(id);
        return new ResponseEntity<>(new Mensaje("eliminado"), HttpStatus.OK);
    }
    

}
