package com.dalmope.FutbolWeb.controller;

import java.util.List;

import com.dalmope.FutbolWeb.DTO.EstadisticasEquipo;
import com.dalmope.FutbolWeb.service.EstadisticasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/estadisticas")
@CrossOrigin(origins = "*")
public class EstadisticasEquipoController {

    @Autowired
    private EstadisticasService estadisticasEquipoService;

    @RequestMapping("/estadisticas")
    @ApiOperation(value = "Obtiene las estadisticas de un equipo")
    public List<EstadisticasEquipo> getEstadisticasEquipo() {
        return (List<EstadisticasEquipo>) estadisticasEquipoService.findAll();
    }

    @RequestMapping("/estadisticas/{id}")
    @ApiOperation(value = "Obtiene las estadisticas de un equipo")
    public String getEstadisticasEquipo(int id) {
        return "estadisticas";
    }

    

    
}
