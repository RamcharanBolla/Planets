package com.planets.planetInfo.controller;

import com.planets.planetInfo.model.Planet;
import com.planets.planetInfo.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
