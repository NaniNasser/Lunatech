package com.example.lunatech.repositories;

import com.example.lunatech.datamodels.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesDAO extends JpaRepository<Country, Long> {
}
