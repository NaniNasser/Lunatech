package com.example.lunatech.datamodels;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "countries")
public class Country {

    @Id
    private Long id;

    private String code;
    private String name;
    private String continent;
    private String wikipedia_link;
    private String keywords;
}
