package com.mongo.examples.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "shipwrecks")
public class ShipWreck {

    @Id
    private String id;

    private String recrd;
    private String vesslterms;
    private String featureType;
    private String chart;
    
    private double latdec;
    private double londec;
    private String gpQuality;
    private int depth;
    private String soundingType;
    private String history;
    private String quasou;
    private String watlev;
    private List<Double> coordinates;

    // Getters and setters
}

