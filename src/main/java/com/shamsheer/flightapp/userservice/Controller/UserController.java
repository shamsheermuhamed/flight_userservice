package com.shamsheer.flightapp.userservice.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shamsheer.flightapp.userservice.Entity.User;
import com.shamsheer.flightapp.userservice.Repo.UserRepository;
import com.shamsheer.flightapp.userservice.Service.UserService;
import com.shamsheer.flightapp.userservice.config.MessageResponse;


@RestController
@CrossOrigin
@RequestMapping("/flight")
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired 
	UserRepository repo;
	
	
	@GetMapping(value="/users")
	Iterable<User> getAllUser()
	{
		return service.getAllUsers();
	}
	@GetMapping(value="/users/{id}")
	Optional<User> getUserById(@PathVariable Integer userId)
	{
		return service.getUserById(userId);
	}
	
	@PostMapping(value="/users/add")
	ResponseEntity<?> addNewUser(@RequestBody User newUser)
	{	
		if (repo.existsByUsername(newUser.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (repo.existsByUseremail(newUser.getUseremail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		newUser.setRoles("ROLE_USER");
		service.addNewUser(newUser);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));	}
}
