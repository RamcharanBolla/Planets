package com.mongo.examples.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class PlanetShipWreck {

    @JsonProperty("_id")
    private ObjectId id;
    private String name;
    private int orderFromSun;

    private boolean hasRings;

    private List<String> mainAtmosphere;

    private SurfaceTemperatureC surfaceTemperatureC;



    @JsonProperty("id")
    private String sId;

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
