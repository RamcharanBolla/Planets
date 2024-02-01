package com.planets.planetInfo.model;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class SurfaceTemperatureC {
    private Object min;
    private Object max;
    private double mean;
}
