package com.shamsheer.flightapp.userservice.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shamsheer.flightapp.userservice.Entity.User;
import com.shamsheer.flightapp.userservice.Repo.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user= repo.findByUsername(username);
		if(user==null)
		{
			throw new  UsernameNotFoundException("user not found");
		}
		CustomUserDetails customUserDetails= new CustomUserDetails(user);
		return customUserDetails;
	}
}
