package com.mongo.examples.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
    @Primary
    @Bean(name = "planetProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.planets")
    MongoProperties getPlanetProps() throws Exception {
        return new MongoProperties();
    }

    @Bean(name = "shipwreckProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.shipwrecks")
    MongoProperties getShipwrecksProps() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "planetMongoTemplate")
    MongoTemplate newdb1MongoTemplate() throws Exception {
        return new MongoTemplate(planetMongoDatabaseFactory(getPlanetProps()));
    }

    @Bean(name = "shipwreckMongoTemplate")
    MongoTemplate newdb2MongoTemplate() throws Exception {
        return new MongoTemplate(shipwreckMongoDatabaseFactory(getShipwrecksProps()));
    }

    @Primary
    @Bean
    MongoDatabaseFactory planetMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(mongo.getUri());
    }

    @Bean
    MongoDatabaseFactory shipwreckMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(mongo.getUri());
    }

}
