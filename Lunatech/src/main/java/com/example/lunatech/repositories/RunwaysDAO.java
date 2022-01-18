package com.example.lunatech.repositories;

import com.example.lunatech.datamodels.Runway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunwaysDAO extends JpaRepository<Runway, Long> {
}
