package com.shamsheer.flightapp.userservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String useremail;
	private String userpassword;
	private String role;
	
	public User()
	{
		
	}
	public User(Integer id, String username,  String userpassword,String useremail) {
		super();
		this.id = id;
		this.username = username;
		this.useremail = useremail;
		this.userpassword = userpassword;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getRole() {
		return role;
	}
	public void setRoles(String role) {
		this.role = role;
	}
	
	
}
