package com.navigoapp.Navigo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @JsonProperty("name")
    public String name;
    @JsonProperty("vehicleNo")
    public int vehicleNo;
    @JsonProperty("color")
    public String color;
    @JsonProperty("source")
    public String source;
    @JsonProperty("destination")
    public String destination;

    public Vehicles() {
    }

    public Vehicles(Long Id, String name, int vehicleNo, String color, String source, String destination) {
        this.Id = Id;
        this.name = name;
        this.vehicleNo = vehicleNo;
        this.color = color;
        this.source = source;
        this.destination = destination;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
