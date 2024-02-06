package com.mongo.examples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mongo.examples.model.ShipWreck;
import com.mongo.examples.shipwreck.repository.ShipwreckRepository;

@Service
public class ShipwreckService {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    //Page<T> findAll(Pageable pageable);
    public List<ShipWreck> getShipWrecks(int size) {
    	Pageable pageable = Pageable.ofSize(size);
    	Page<ShipWreck> pageShipWreckData = shipwreckRepository.findAll(pageable);
        return pageShipWreckData.toList();
    }
}
