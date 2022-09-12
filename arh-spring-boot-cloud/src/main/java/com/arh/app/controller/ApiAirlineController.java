package com.arh.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arh.app.interfaces.APIClient;
import com.arh.app.dto.DtoAirline;
import com.arh.app.dto.DtoPrueba;

@RestController
public class ApiAirlineController {

	private final APIClient apiClient;

	public ApiAirlineController(APIClient apiClient){
	  this.apiClient = apiClient;
	}
    
	@GetMapping(value = "/airlinesList", produces = {"application/json", "text/xml"})
	  public ResponseEntity<List<Map<String, String>>> listAllData () {
		      System.out.println("MSG ALONSO 2.0::");
		      System.out.println("MSG ALONSO 2.1::"+apiClient.readAirLines().size());
	          return ResponseEntity.ok(apiClient.readAirLines());
	  }
	
	@GetMapping(value = "/airline/{airlineId}", produces = {"application/json", "text/xml"})
	public ResponseEntity<DtoAirline> readAirlineData (@PathVariable String airlineId) {
	      System.out.println("MSG ALONSO 1.0::"+ airlineId);
	      System.out.println("MSG ALONSO 1.2::"+ apiClient);
	      System.out.println("MSG ALONSO 1.3::"+ apiClient.readAirLineById(airlineId));
          
	      return ResponseEntity.ok(apiClient.readAirLineById(airlineId));
	}
	
	
	//## Esta código es solo una prueba##
	@GetMapping(value = "/pruebaList", produces = {"application/json", "text/xml"})
    public ResponseEntity<List<DtoPrueba>> getShippingCountries() {
        Map<String, String> map = new HashMap<>();
        map.put("Lima", "LIM");
        map.put("Jauja", "JAU");
        List<DtoPrueba> list = getCustomisedData(map);
        return ResponseEntity.ok(list);
    }

    private List<DtoPrueba> getCustomisedData(Map<String, String> map) {
        List<DtoPrueba> dtos = new ArrayList<DtoPrueba>();
        for(Entry<String, String> value: map.entrySet()) {
            DtoPrueba dto = new DtoPrueba();
            dto.setKey(value.getKey());
            dto.setValue(value.getValue());
            dtos.add(dto);
        }
        return dtos;
    }

}
