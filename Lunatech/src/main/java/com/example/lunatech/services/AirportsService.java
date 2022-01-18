package com.example.lunatech.services;

import com.example.lunatech.datamodels.Airport;
import com.example.lunatech.datamodels.CountryCounter;
import com.example.lunatech.repositories.AirportDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportsService {


    private AirportDAO airportDAO;


    public AirportsService(AirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }

    public Optional<List<CountryCounter>> countriesWithMostAirports() {
        List<CountryCounter> countryList = airportDAO.findTopTenCountries();
        return Optional.of(countryList);
    }

    public Optional<List<CountryCounter>> countriesWithLeastAirports() {
        List<CountryCounter> countryList = airportDAO.findBottomTenCountries();
        return Optional.of(countryList);
    }

    public Optional<List<Airport>> airportByCountry(String country) {
        if(country.length() > 2)
            return Optional.of(airportDAO.findByName(country));
        else
            return Optional.of(airportDAO.findByCountryCode(country));
    }
}
