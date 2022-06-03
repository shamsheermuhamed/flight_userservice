package com.shamsheer.flightapp.userservice.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shamsheer.flightapp.userservice.Entity.Discount;
import com.shamsheer.flightapp.userservice.Entity.Ticket;
import com.shamsheer.flightapp.userservice.Repo.TicketRepository;


@Service
public class TicketService {
 
	@Autowired
	TicketRepository repo;
	
	@Autowired
	RestTemplate template;
	
	public Iterable<Ticket> getAllTickets()
	{
		return repo.findAll();
	}
	
//	public List<Ticket> getAllTicketsByUser(Integer userId)
//	{
//		return repo.findByUserdetails(userId);
//	}
	public void createTicket(Ticket ticket)
	{
		
		repo.save(ticket);
	}

	public void updateTicket(Ticket newTicket) {
		// TODO Auto-generated method stub
		repo.save(newTicket);
		
	}
	public Optional<Ticket> getByTicketId(Integer ticketid) {
		// TODO Auto-generated method stub
		return repo.findById(ticketid);
	}

	public void deleteTicketById(Integer ticketid) {
		// TODO Auto-generated method stub
		repo.deleteById(ticketid);
	}

	//@HystrixCommand(fallbackMethod="stillCreateTicket")
	public void createTicketWithCoupon(Ticket newTicket, Integer couponcode) {
		// TODO Auto-generated method stub
		//Connecting microservice adminsvc and usersvc
    	String url="http://localhost:8089/discounts";
    	List<Discount> ds=Arrays.asList(template.getForObject(url, Discount[].class));
    	ds.forEach(p-> {
    		if(p.getCouponid()==couponcode)
    		{newTicket.setTotalprice(newTicket.getTotalprice()-p.getDiscountamount());}
    	});
    	
    	repo.save(newTicket);
	}
	
	public void stillCreateTicket(Ticket newTicket)
	{
		repo.save(newTicket);
	}

	
}
