package com.mongo.examples.reactive.repository;
import com.mongo.examples.reactive.shipwreck.repository.ShipwreckReactiveRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import com.mongo.examples.model.ShipWreck;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ShipwreckReactiveRepositoryTests {
    private static Logger logger = LoggerFactory.getLogger(ShipwreckReactiveRepositoryTests.class);
    @Autowired
    private ShipwreckReactiveRepository shipwreckReactiveRepository;

    @Test
    public void testFindAll() {
        Flux<ShipWreck> shipwrecksFlux = shipwreckReactiveRepository.findAll().onBackpressureBuffer(10);
        shipwrecksFlux.subscribe(
                item -> logger.info("Merged item: {}", item),
                error -> logger.error("Error occurred in merge flux: {}", error.getMessage()),
                () -> logger.info("Merge flux completed")
        );
        StepVerifier.create(shipwrecksFlux)
                .expectNextCount(10) // Adjust this count based on the expected number of shipwrecks
                .verifyComplete();
    }

}