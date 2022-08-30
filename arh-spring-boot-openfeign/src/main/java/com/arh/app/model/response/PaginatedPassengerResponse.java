package com.arh.app.model.response;

import java.util.List;

import lombok.Data;

@Data
public class PaginatedPassengerResponse {
    private Long totalPassengers;
    private Long totalPages;
    private List<PassengerResponse> data;
}
