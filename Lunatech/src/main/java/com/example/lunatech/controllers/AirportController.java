package com.example.lunatech.controllers;
import com.example.lunatech.datamodels.Airport;
import com.example.lunatech.datamodels.CountryCounter;
import com.example.lunatech.services.AirportsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("airports")
public class AirportController {
    private AirportsService airportsService;

    public AirportController(AirportsService airportsService) {
        this.airportsService = airportsService;
    }

    @GetMapping("/top")
    public ResponseEntity getCountriesWithMostAirports() {

        Optional<List<CountryCounter>> countryCounters = airportsService.countriesWithMostAirports();
        if (countryCounters.isPresent())
            return ResponseEntity.ok(countryCounters.get());

        return ResponseEntity.badRequest().body("Something went wrong");
    }

    @GetMapping("/bottom")
    public ResponseEntity getCountriesWithLeastAirports() {

        Optional<List<CountryCounter>> countryCounters = airportsService.countriesWithLeastAirports();
        if (countryCounters.isPresent())
            return ResponseEntity.ok(countryCounters.get());

        return ResponseEntity.badRequest().body("Something went wrong");
    }

    @GetMapping("/query/{country}")
    public ResponseEntity findByCountryCode(@PathVariable String country) {

        Optional<List<Airport>> airportList = airportsService.airportByCountry(country);
        if (airportList.isPresent())
            return ResponseEntity.ok(airportList.get());

        return ResponseEntity.badRequest().body("Something went wrong");
    }

}
