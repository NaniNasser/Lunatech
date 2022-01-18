package com.example.lunatech.datafactory;

import com.example.lunatech.datamodels.Airport;
import com.example.lunatech.datamodels.Country;
import com.example.lunatech.datamodels.Runway;
import com.example.lunatech.repositories.AirportDAO;
import com.example.lunatech.repositories.CountriesDAO;
import com.example.lunatech.repositories.RunwaysDAO;
import org.simpleflatmapper.csv.CsvParser;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public abstract class DataBasePopulator {

    public static List<Airport> populateAirportDB(AirportDAO dao) {
        List<Airport> airports = null;
        try {
            File file = ResourceUtils.getFile("classpath:airports.csv");
            airports = CsvParser.mapTo(Airport.class)
                    .headers("id", "ident", "type", "name", "latitude_deg", "longitude_deg", "elevation_ft",
                            "continent", "iso_country", "iso_region", "municipality",
                            "scheduled_service", "gps_code", "iata_code", "local_code",
                            "home_link", "wikipedia_link", "keywords")
                    .stream(file, s -> s)
//                    .limit(50)
                    .collect(Collectors.toList());
            dao.saveAll(airports);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return airports;
    }

    public static void populateCountryDB(CountriesDAO dao) {
        try {
            File file = ResourceUtils.getFile("classpath:countries.csv");
            List<Country> countries = CsvParser.mapTo(Country.class)
                    .headers("id","code","name","continent","wikipedia_link","keywords")
                    .stream(file, s -> s)
                    .collect(Collectors.toList());
            dao.saveAll(countries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void populateRunwayDB(RunwaysDAO dao) {
        try {
            File file = ResourceUtils.getFile("classpath:runways.csv");
            List<Runway> runways = CsvParser.mapTo(Runway.class)
                    .headers("id","airport_ref","airport_ident","length_ft","width_ft",
                            "surface","lighted","closed","le_ident","le_latitude_deg",
                            "le_longitude_deg","le_elevation_ft","le_heading_degT","le_displaced_threshold_ft",
                            "he_ident","he_latitude_deg","he_longitude_deg","he_elevation_ft","he_heading_degT",
                            "he_displaced_threshold_ft")
                    .stream(file, s -> s)
                    .collect(Collectors.toList());
            dao.saveAll(runways);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
