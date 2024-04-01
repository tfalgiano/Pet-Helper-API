package org.opensource.pethelper.controller;

import org.opensource.pethelper.enums.Pets;
import org.opensource.pethelper.enums.Services;
import org.opensource.pethelper.model.nearbySearchResult.NearbySearchResponse;
import org.opensource.pethelper.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pet")
public class PetHelperController {

    @Resource
    LocationService locationService;

    @GetMapping("/")
    public ResponseEntity<NearbySearchResponse> getNearbyServices(
            @Valid @RequestParam(value = "service", required = false) Services service,
            @Valid @RequestParam(value = "animal", required = false) Pets pet,
            @Valid @RequestParam(value = "zipCode", required = true) String zipCode) {
        return new ResponseEntity<>(locationService.getGeocodeData(zipCode, service, pet), HttpStatus.OK);
    }
}