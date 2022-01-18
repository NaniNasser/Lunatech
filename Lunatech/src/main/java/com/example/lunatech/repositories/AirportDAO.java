package com.example.lunatech.repositories;

import com.example.lunatech.datamodels.Airport;
import com.example.lunatech.datamodels.CountryCounter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AirportDAO extends JpaRepository<Airport, Long> {
    /*@Query("SELECT COUNT(a), a.iso_country FROM Airport a GROUP BY a.iso_country order by count(a) DESC")
    List<Object[]> countAirportByIso_country();}*/

    @Query("SELECT new com.example.lunatech.datamodels.CountryCounter(a.iso_country,COUNT(a)) FROM Airport a GROUP BY a.iso_country ORDER BY COUNT(a) DESC")
    List<CountryCounter> topCountries(Pageable pageable);

    @Query("SELECT new com.example.lunatech.datamodels.CountryCounter(a.iso_country,COUNT(a)) FROM Airport a GROUP BY a.iso_country ORDER BY COUNT(a) ASC")
    List<CountryCounter> bottomCountries(Pageable pageable);

    default List<CountryCounter> findTopTenCountries() {
        return topCountries(PageRequest.of(0,10));
    }

    default List<CountryCounter> findBottomTenCountries() {
        return bottomCountries(PageRequest.of(0,10));
    }

    @Query("select a from Airport a where lower(a.iso_country) like lower(concat('%', :nameToFind,'%'))")
    List<Airport> findByCountryCode(@Param("nameToFind") String name);

    @Query("select a, c.code from Airport a INNER JOIN Country c ON c.code = a.iso_country " +
            "WHERE lower(c.name) like lower(concat('%', :nameToFind,'%'))")
    List<Airport> findByName(@Param("nameToFind") String name);
}

