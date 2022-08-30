package com.arh.app.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PassengerResponse {
    @JsonProperty(value = "_id")
    private String id;
    private String name;
    private Long trips;
    private AirlineResponse airline;
}
