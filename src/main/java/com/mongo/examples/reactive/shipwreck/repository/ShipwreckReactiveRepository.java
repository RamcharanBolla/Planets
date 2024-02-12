package com.mongo.examples.reactive.shipwreck.repository;

import com.mongo.examples.model.ShipWreck;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipwreckReactiveRepository extends ReactiveMongoRepository<ShipWreck,String> {

}
