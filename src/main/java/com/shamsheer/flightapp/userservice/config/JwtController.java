package com.shamsheer.flightapp.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shamsheer.flightapp.userservice.Repo.UserRepository;
import com.shamsheer.flightapp.userservice.exceptions.RecordNotFoundException;



@CrossOrigin
@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager auth;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwt;
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/")
	public String hello()
	{
		return "hello";
	}
	@GetMapping("/user")
	public String hello1()
	{
		return "user";
	}

	@PostMapping("/signin")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest request) throws Exception
	{
		try {
			
			this.auth.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		}

		catch(BadCredentialsException ex)
		{
			throw new RecordNotFoundException();
		}
		catch(Exception e)
		{
			throw new Exception("Bad");
		}
		
		UserDetails detail= this.customUserDetailsService.loadUserByUsername(request.getUsername());
		String token= this.jwt.generateToken(detail);
		System.out.println(repo.findByUsername(request.getUsername()).getId());
		return ResponseEntity.ok(new JwtResponse(token,
				repo.findByUsername(request.getUsername()).getRole(),
				repo.findByUsername(request.getUsername()).getId()
				));
	}
}
