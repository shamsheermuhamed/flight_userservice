package com.shamsheer.flightapp.userservice.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passengers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passengerid;
	
	private String passengername;
	private Integer passengerage;
	private String passengergender;
	
	public Passengers() {}
	
	public Passengers(Integer passengerid, String passengername, Integer passengerage, String passengergender) {
		super();
		this.passengerid = passengerid;
		this.passengername = passengername;
		this.passengerage = passengerage;
		this.passengergender = passengergender;
	}
	public Integer getPassengerid() {
		return passengerid;
	}
	public void setPassengerid(Integer passengerid) {
		this.passengerid = passengerid;
	}
	public String getPassengername() {
		return passengername;
	}
	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}
	public Integer getPassengerage() {
		return passengerage;
	}
	public void setPassengerage(Integer passengerage) {
		this.passengerage = passengerage;
	}
	public String getPassengergender() {
		return passengergender;
	}
	public void setPassengergender(String passengergender) {
		this.passengergender = passengergender;
	}
	
	
}
