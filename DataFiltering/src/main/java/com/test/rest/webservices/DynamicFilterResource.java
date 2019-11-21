package com.test.rest.webservices;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilterResource {
	
	
	@PostMapping("/dynamicFilter" )
	public MappingJacksonValue dynamicFilter(@RequestBody Employee employee) {
		
		
		//Employee emp = new Employee("Sanjeev", "33", "Gurgram", "323432234");
		SimpleBeanPropertyFilter beanPropertyFilter  = SimpleBeanPropertyFilter.filterOutAllExcept("name", "age", "address");
	    FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter", beanPropertyFilter);
	    MappingJacksonValue mapping = new MappingJacksonValue(employee);

	    mapping.setFilters(filters);
	
	    return mapping;
		
	}
	
}
