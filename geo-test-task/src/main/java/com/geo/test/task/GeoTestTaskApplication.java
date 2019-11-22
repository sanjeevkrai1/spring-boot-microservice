package com.geo.test.task;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeoTestTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoTestTaskApplication.class, args);
	}
	
	
	@Bean
	ModelMapper getMapper() {
		return new ModelMapper();
	}

}
