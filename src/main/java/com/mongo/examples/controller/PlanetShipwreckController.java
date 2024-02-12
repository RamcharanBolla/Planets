package com.mongo.examples.controller;

import com.mongo.examples.model.Planet;
import com.mongo.examples.model.PlanetShipWreck;
import com.mongo.examples.model.ShipWreck;
import com.mongo.examples.service.PlanetShipwreckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
@RequestMapping("/planetshipwreck")
public class PlanetShipwreckController {
    @Autowired
    private PlanetShipwreckService planetShipwreckService;
    @GetMapping("/{size}")
    public Flux<PlanetShipWreck> getPlanetShipWreck(@PathVariable int size){
        return planetShipwreckService.getAllPlanetsShipWreck(size);
    }

    @GetMapping("/planets")
    public Flux<Planet> getAllPlanets(){
        return planetShipwreckService.getAllPlanets();
    }

    @GetMapping(value = "/shipwreck")
    public Flux<ShipWreck> getAllShipwrecks(){
        return planetShipwreckService.getAllShipWrecks();
    }
}
