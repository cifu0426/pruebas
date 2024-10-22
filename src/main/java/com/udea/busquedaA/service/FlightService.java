package com.udea.busquedaA.service;

import com.udea.busquedaA.model.Flight;
import com.udea.busquedaA.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Buscar vuelos por origen
    public List<Flight> findFlightsByOrigin(String origin) {
        return flightRepository.findByOrigin(origin);
    }

    // Buscar vuelos por destino
    public List<Flight> findFlightsByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }
}