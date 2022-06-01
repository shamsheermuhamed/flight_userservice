package com.shamsheer.flightapp.userservice.config;

public class JwtResponse {

	String token;
	String role;
	Integer userid;
	
	public JwtResponse()
	{
		
	}

	public JwtResponse(String token, String role, Integer userid) {
		super();
		this.token = token;
		this.role = role;
		this.userid = userid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	
}
