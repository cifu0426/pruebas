package com.udea.busquedaA.resolver;

import com.udea.busquedaA.model.Flight;
import com.udea.busquedaA.model.FlightClass;
import com.udea.busquedaA.repository.FlightClassRepository;
import com.udea.busquedaA.repository.FlightRepository;
import com.udea.busquedaA.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

    @Controller
    public class FlightResolver {

        @Autowired
        private FlightRepository flightRepository;
        @Autowired
        private FlightService flightService;

        // Consultar un vuelo por ID
        @QueryMapping
        public Flight findFlightById(@Argument Integer id) {
            return flightRepository.findById(id).orElse(null);
        }

        @QueryMapping
        public List<Flight> findFlightsByOrigin(@Argument String origin) {
            return flightService.findFlightsByOrigin(origin);
        }

        // Consulta para buscar por destino
        @QueryMapping
        public List<Flight> findFlightsByDestination(@Argument String destination) {
            return flightService.findFlightsByDestination(destination);
        }
    }
