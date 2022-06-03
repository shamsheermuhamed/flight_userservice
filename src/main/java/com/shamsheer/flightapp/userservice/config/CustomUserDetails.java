package com.shamsheer.flightapp.userservice.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shamsheer.flightapp.userservice.Entity.User;

public class CustomUserDetails implements UserDetails {

	String UserName,Password,role;
	List<SimpleGrantedAuthority> authorities;
	
	public CustomUserDetails(User user) {
		this.UserName=user.getUsername();
		this.Password=user.getUserpassword();
		this.authorities=Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).
				collect(Collectors.toList());
		this.role=user.getRole();
	}
		
	
	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.Password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.UserName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
