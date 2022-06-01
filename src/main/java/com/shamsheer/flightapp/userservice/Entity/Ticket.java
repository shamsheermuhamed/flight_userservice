package com.shamsheer.flightapp.userservice.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketid;
	
	@ManyToMany
	private List<Passengers> passengers=new ArrayList<>();
	
	@ManyToOne
	private User userdetails;
	private Integer totalseats;
	private Double totalprice;
	
	private Integer flightid;
	public Ticket()
	{
		
	}

	public Ticket(List<Passengers> passengers, User userdetails, Integer totalseats,
			Double totalprice, Integer flightid) {
		super();
		this.passengers = passengers;
		this.userdetails = userdetails;
		this.totalseats = totalseats;
		this.totalprice = totalprice;
		this.flightid = flightid;
	}







	public Integer getTicketid() {
		return ticketid;
	}

	public void setTicketid(Integer ticketid) {
		this.ticketid = ticketid;
	}

	public User getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Integer userId) {
		this.userdetails = new User(userId,"","","");
	}

	public Integer getTotalseats() {
		return totalseats;
	}

	public void setTotalseats(Integer totalseats) {
		this.totalseats = totalseats;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public List<Passengers> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

	public Integer getFlightid() {
		return flightid;
	}
	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}
	
	
}
