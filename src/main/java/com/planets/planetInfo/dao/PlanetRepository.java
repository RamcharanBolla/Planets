package com.planets.planetInfo.dao;

import com.planets.planetInfo.model.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends MongoRepository<Planet,String> {

    Optional<Planet> findByName(String name);

    List<Planet> findPlanetByhasRings(boolean hasRings);
}
