package com.mongo.examples.reactive.planet.repository;

import com.mongo.examples.model.Planet;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetReactiveRepository extends ReactiveMongoRepository<Planet, ObjectId> {
//    LoggerFactory.getLogger(PlanetReactiveRepository.class);
}
