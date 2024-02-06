package com.mongo.examples.config.db;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.mongo.examples.planet.repository"},
mongoTemplateRef = PlanetDbConfig.MONGO_TEMPLATE
)
public class PlanetDbConfig {
    protected static final String MONGO_TEMPLATE = "planetMongoTemplate";
}
