package com.mongo.examples.planet.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.examples.model.Planet;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends MongoRepository<Planet,ObjectId> {

    Optional<Planet> findByName(String name);

    List<Planet> findPlanetByhasRings(boolean hasRings);
}
