package com.arh.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arh.app.client.InstantWebToolsAPIClient;
import com.arh.app.model.request.AirlineCreateRequest;
import com.arh.app.model.request.PassengerUpdateRequest;

import lombok.RequiredArgsConstructor;

@RestController
public class ApiController {

  private final InstantWebToolsAPIClient apiClient;
  
  public ApiController(InstantWebToolsAPIClient apiClient){
	  this.apiClient = apiClient;
	}
  
  @GetMapping(value = "/airline/{airlineId}")
  public ResponseEntity readAirlineData (@PathVariable String airlineId) {
      
      System.out.println("MSG ALONSO 1.0::"+ airlineId);
      System.out.println("MSG ALONSO 1.2::"+ apiClient);
      if (airlineId == null) {
          return ResponseEntity.ok(apiClient.readAirLines());
      }
      return ResponseEntity.ok(apiClient.readAirLineById(airlineId));
  }

  @GetMapping(value = "/passengers")
  public ResponseEntity readPassengers () {
      return ResponseEntity.ok(apiClient.readPassengers(20L, 0L));
  }

  @PostMapping(value = "/airline")
  public ResponseEntity createAirline (@RequestBody AirlineCreateRequest request) { //@RequestBody funciona solo application/json
  // public ResponseEntity createAirline (@ModelAttribute AirlineCreateRequest request) { //@ModelAttribute funciona con form-data o application/x-www-form-urlencoded
  
      System.out.println("MSG ALONSO POST ::"+ request);
      return ResponseEntity.ok(apiClient.createAirline(request));
  }

  @DeleteMapping(value = "/passenger/{id}")
  public ResponseEntity deletePassenger (@PathVariable String id) {
      return ResponseEntity.ok(apiClient.deletePassenger(id));
  }

  @PatchMapping(value = "/passenger/{id}")
  public ResponseEntity updatePassenger (@PathVariable String id, @RequestBody PassengerUpdateRequest request) {
      return ResponseEntity.ok(apiClient.updatePassenger(id, request));
  }

}

