package com.mongo.examples.service;

import com.mongo.examples.model.Planet;
import com.mongo.examples.model.PlanetShipWreck;
import com.mongo.examples.model.ShipWreck;
import com.mongo.examples.reactive.planet.repository.PlanetReactiveRepository;
import com.mongo.examples.reactive.shipwreck.repository.ShipwreckReactiveRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;



@Service
public class PlanetShipwreckService {

    private static final Logger logger = LoggerFactory.getLogger(PlanetShipwreckService.class);

    @Autowired
    private PlanetReactiveRepository planetReactiveRepository;

    @Autowired
    private ShipwreckReactiveRepository shipwreckReactiveRepository;

    public Flux<Planet> getAllPlanets(){
        logger.info("Here in getAllPlanets() service");
        return planetReactiveRepository.findAll().log()
                .doOnNext(shipwreck -> logger.info("Received planets: {}", shipwreck))
                .doOnError(error -> logger.error("Error occurred while fetching planets: {}", error.getMessage()));
    }
    public Flux<PlanetShipWreck> getAllPlanetsShipWreck(int size){
        logger.info("Here in getAllPlanetsShipWreck()");

        Flux<Planet> allPlanets = planetReactiveRepository.findAll().log()
                .doOnNext(shipwreck -> logger.info("Received planets: {}", shipwreck))
                .doOnError(error -> logger.error("Error occurred while fetching planets: {}", error.getMessage()));

        //Pageable pageable = Pageable.ofSize(size);
        logger.info("After allPlanets repo call");
        Flux<ShipWreck> allShipwrecks = shipwreckReactiveRepository.findAll().log()
                .doOnNext(shipwreck -> logger.info("Received ShipWreck: {}", shipwreck))
                .doOnError(error -> logger.error("Error occurred while fetching ShipWrecks: {}", error.getMessage()));
        ;
        logger.info("After allShipWrecks repo call");

        Flux<Object> merge = Flux.merge(allPlanets, allShipwrecks);
        merge.subscribe(
                item -> logger.info("Merged item: {}", item),
                error -> logger.error("Error occurred in merge flux: {}", error.getMessage()),
                () -> logger.info("Merge flux completed")
        );
        return Flux.zip(allPlanets, allShipwrecks, this::mergeToPlanetShipWreck)
                .take(size);

    }

    private PlanetShipWreck mergeToPlanetShipWreck(Planet planet, ShipWreck shipWreck) {

        return new PlanetShipWreck(planet.getId(),
                planet.getName(),
                planet.getOrderFromSun(),
                planet.isHasRings(),
                planet.getMainAtmosphere(),
                planet.getSurfaceTemperatureC(),
                shipWreck.getId(),
                shipWreck.getRecrd(),
                shipWreck.getVesslterms(),
                shipWreck.getFeatureType(),
                shipWreck.getChart(),
                shipWreck.getLatdec(),
                shipWreck.getLondec(),
                shipWreck.getGpQuality(),
                shipWreck.getDepth(),
                shipWreck.getSoundingType(),
                shipWreck.getHistory(),
                shipWreck.getQuasou(),
                shipWreck.getWatlev(),
                shipWreck.getCoordinates());

    }

    public Flux<ShipWreck> getAllShipWrecks() {
//        Pageable pageable = Pageable.ofSize(size);
        logger.info("Fetching all shipwrecks...");
        return shipwreckReactiveRepository.findAll().log()
                .doOnNext(shipwreck -> logger.info("Received ShipWreck: {}", shipwreck))
                .doOnError(error -> logger.error("Error occurred while fetching ShipWrecks: {}", error.getMessage()));

    }
}
