package com.udea.busquedaA.repository;

import com.udea.busquedaA.model.FlightClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightClassRepository extends JpaRepository<FlightClass, Integer> {
}
