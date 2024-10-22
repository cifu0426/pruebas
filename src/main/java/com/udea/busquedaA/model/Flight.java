package com.udea.busquedaA.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFlight;

    private String origin;
    private String destination;
    @ManyToOne
    @JoinColumn(name = "id_flight_class", nullable = false, updatable = false)
    private FlightClass flightClass;
    private String flightCode;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Integer price;

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }


    public Flight() {
    }

    public Flight(Integer idFlight, String origin, String destination, FlightClass flightClass, String flightCode, LocalDate departureDate, LocalDate arrivalDate, LocalTime departureTime, LocalTime arrivalTime, Integer price, Integer totalPrice) {
        this.idFlight = idFlight;
        this.origin = origin;
        this.destination = destination;
        this.flightClass = flightClass;
        this.flightCode = flightCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    @Transient
    public Duration getDuration() {
        return Duration.between(departureTime, arrivalTime);
    }

    @Transient
    public String getDurationFormat() {
        Duration duration = getDuration();
        int hours = (int) duration.toHours();
        int minutes = duration.toMinutesPart();
        return hours + " horas y " + minutes + " minutos";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(idFlight, flight.idFlight);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idFlight);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Transient
    public double getTotalPrice() {
        Integer extraPrice = flightClass != null ? flightClass.getExtraPrice() : 0;
        return (price != null ? price : 0) + (extraPrice != null ? extraPrice : 0);
    }

}
