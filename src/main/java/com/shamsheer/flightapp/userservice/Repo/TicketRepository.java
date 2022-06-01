package com.shamsheer.flightapp.userservice.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shamsheer.flightapp.userservice.Entity.Ticket;



@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
	
	//@Query(value="select t from Ticket t where t.user_details=(select s from User s where t.user_id=?1)" )
	List<Ticket> findByUserdetailsId(Integer userId);

	
}
