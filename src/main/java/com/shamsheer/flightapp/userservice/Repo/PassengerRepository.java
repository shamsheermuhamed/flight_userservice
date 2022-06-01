package com.shamsheer.flightapp.userservice.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shamsheer.flightapp.userservice.Entity.Passengers;



@Repository
public interface PassengerRepository extends CrudRepository<Passengers, Integer>{

}
