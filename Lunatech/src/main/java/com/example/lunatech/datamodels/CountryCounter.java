package com.example.lunatech.datamodels;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryCounter {
    String country;
    Long count;

    @Override
    public String toString() {
        return country + "=" + count ;
    }
}

