package com.arh.app.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arh.app.config.FeignClientConfiguration;
import com.arh.app.dto.DtoAirline;

@FeignClient(value = "${app.feign.config.name}", url = "${app.feign.config.url}", configuration = FeignClientConfiguration.class)
public interface APIClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/airlines")
	List<Map<String, String>> readAirLines();
    	
    @RequestMapping(method = RequestMethod.GET, value = "/airlines/{airlineId}")
    DtoAirline readAirLineById(@PathVariable String airlineId);
    

}
