package com.example.lunatech;

import com.example.lunatech.datafactory.DataBasePopulator;
import com.example.lunatech.datamodels.Airport;
import com.example.lunatech.repositories.AirportDAO;
import com.example.lunatech.repositories.CountriesDAO;
import com.example.lunatech.repositories.RunwaysDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class LunatechApplication {

    public static void main(String[] args) {
        //SpringApplication.run(LunatechApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(LunatechApplication.class, args);
        generateData(context);
    }

    public static void generateData(ConfigurableApplicationContext context) {
        DataBasePopulator.populateAirportDB(context.getBean(AirportDAO.class));
        DataBasePopulator.populateCountryDB(context.getBean(CountriesDAO.class));
        DataBasePopulator.populateRunwayDB(context.getBean(RunwaysDAO.class));
    }


}




