package com.dalmope.FutbolWeb.controller;

import java.util.List;

import com.dalmope.FutbolWeb.DTO.Equipo;
import com.dalmope.FutbolWeb.DTO.Mensaje;
import com.dalmope.FutbolWeb.service.EquipoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/equipo")
@CrossOrigin(origins = "*")
public class EquipoController {
    

    @Autowired
    private EquipoService equipoService;

    @ApiOperation("Devuelve un equipo segun su ID")
    @GetMapping("/{codigo}")
    public ResponseEntity<?> findByCodigo(@PathVariable("codigo") Integer codigo) {
        if (!equipoService.existsByCodigo(codigo)) {
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Equipo equipo = equipoService.findByCodigo(codigo);
        return new ResponseEntity<>(equipo, HttpStatus.OK);
    }

    @ApiOperation("Devuelve un listado de equipos")
    @GetMapping
    public ResponseEntity<List<Equipo>> list() {
        List<Equipo> equipos = equipoService.findAll();
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @ApiOperation("Agrega un equipo")
    @PostMapping
    public void save(@RequestBody Equipo equipo) {
        equipoService.save(equipo);
    }

    @ApiOperation("Borra un equipo")
    @DeleteMapping
    public void delete(@RequestBody Equipo equipo) {
        equipoService.delete(equipo);
    }

    @ApiOperation("Borra un equipo por ID")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        equipoService.deleteById(id);
    }
    
}
