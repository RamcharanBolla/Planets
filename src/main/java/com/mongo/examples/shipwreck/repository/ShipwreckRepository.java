package com.mongo.examples.shipwreck.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.examples.model.ShipWreck;

@Repository
public interface ShipwreckRepository extends MongoRepository<ShipWreck,String> {

}
