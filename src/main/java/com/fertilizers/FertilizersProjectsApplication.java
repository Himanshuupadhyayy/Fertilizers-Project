package com.fertilizers;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FertilizersProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FertilizersProjectsApplication.class, args);
		
		System.out.println("working");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
