package com.mongo.examples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.examples.model.ShipWreck;
import com.mongo.examples.service.ShipwreckService;

@RestController
@RequestMapping("/shipwreck")
public class ShipwreckController {

    @Autowired
    private ShipwreckService shipwreckService;
    
    @GetMapping("/{size}")
    public List<ShipWreck> getShipWrecks(@PathVariable int size){
        return shipwreckService.getShipWrecks(size);
    }

}