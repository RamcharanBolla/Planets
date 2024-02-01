package com.planets.planetInfo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@ToString
@Document(collection = "planets")
public class Planet {

    @Id
    @JsonProperty("_id")
    private ObjectId id;
    private String name;
    private int orderFromSun;

    private boolean hasRings;

    private List<String> mainAtmosphere;

    private SurfaceTemperatureC surfaceTemperatureC;

}
