package com.udea.busquedaA.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class FlightClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFlightClass;

    private String flightClassName;
    private Integer luggageAmount;

    public Integer getExtraPrice() {
        return extraPrice;
    }

    private Integer extraPrice;

    public FlightClass() {
    }

    public FlightClass(Integer idFlightClass, String flightClassName, Integer luggageAmount, Integer extraPrice, List<Flight> flights) {
        this.idFlightClass = idFlightClass;
        this.flightClassName = flightClassName;
        this.luggageAmount = luggageAmount;
        this.extraPrice = extraPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightClass that = (FlightClass) o;
        return Objects.equals(idFlightClass, that.idFlightClass);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idFlightClass);
    }
}
