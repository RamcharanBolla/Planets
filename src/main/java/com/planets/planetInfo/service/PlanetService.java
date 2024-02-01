package com.planets.planetInfo.service;

import com.planets.planetInfo.dao.PlanetRepository;
import com.planets.planetInfo.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;
    public List<Planet> getPlanets() {
        return planetRepository.findAll();
    }

    public Optional<Planet> getPlanetByName(String name) {
        return planetRepository.findByName(name);
    }

    public List<Planet> getPlanetWithRings(boolean hasRings) {
        return planetRepository.findPlanetByhasRings(hasRings);
    }
}
