package com.udea.busquedaA.repository;

import com.udea.busquedaA.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByOrigin(String origin);

    List<Flight> findByDestination(String destination);

}
