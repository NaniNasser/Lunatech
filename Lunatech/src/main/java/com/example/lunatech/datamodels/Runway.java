package com.example.lunatech.datamodels;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "runways")
public class Runway {

    @Id
    private Integer id;

    private Integer airport_ref;
    private String airport_ident;
    private Double length_ft;
    private Double width_ft;
    private String surface;
    private Integer lighted;
    private Integer closed;
    private String le_ident;
    private Double le_latitude_deg;
    private Double le_longitude_deg;
    private Integer le_elevation_ft;
    private Double le_heading_degT;
    private Integer le_displaced_threshold_ft;
    private String he_ident;
    private Double he_latitude_deg;
    private Double he_longitude_deg;
    private Integer he_elevation_ft;
    private Double he_heading_degT;
    private Double he_displaced_threshold_ft;
}
