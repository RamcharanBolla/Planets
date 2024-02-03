package com.mongo.examples.config.db;

//NewDb2Config.java
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.mongo.examples.shipwreck.repository"},
mongoTemplateRef = ShipwreckDbConfig.MONGO_TEMPLATE
)
public class ShipwreckDbConfig {
  protected static final String MONGO_TEMPLATE = "shipwreckMongoTemplate";
}