package com.shamsheer.flightapp.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
//@EnableCircuitBreaker
public class FlightUserSvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(FlightUserSvc1Application.class, args);
	}

	@Bean
	RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
