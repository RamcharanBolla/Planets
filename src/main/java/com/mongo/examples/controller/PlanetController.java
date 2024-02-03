package com.mongo.examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.examples.model.Planet;
import com.mongo.examples.service.PlanetService;

import java.util.List;
import java.util.Optional;

@RestController
public class PlanetController {

    @Autowired
    private PlanetService planetService;
    @GetMapping("/planets")
    public List<Planet> getPlanets(){
        return planetService.getPlanets();
    }

    @GetMapping("/planets/{name}")
    public Optional<Planet> getPlanetByName(@PathVariable String name){
        return planetService.getPlanetByName(name);
    }

    @GetMapping("planets/with-rings")
    public List<Planet> getPlanetWithRings(@RequestParam boolean hasRings){
        return planetService.getPlanetWithRings(hasRings);
    }
}
