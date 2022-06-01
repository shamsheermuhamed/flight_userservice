package com.shamsheer.flightapp.userservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shamsheer.flightapp.userservice.Entity.Passengers;
import com.shamsheer.flightapp.userservice.Service.PassengersService;

@CrossOrigin
@RestController
@RequestMapping("/flight")
public class PassengerController {
	
	@Autowired
	PassengersService service;
	
	@PostMapping("/passenger/add")
	void addPassenger(@RequestBody Passengers thepass)
	{
		service.addPassengers(thepass);
	}
	@DeleteMapping("/passenger/delete/{pid}")
	void deletePassenegrById(@PathVariable Integer pid)
	{
		service.deletePassenegrById(pid);
	}

}
