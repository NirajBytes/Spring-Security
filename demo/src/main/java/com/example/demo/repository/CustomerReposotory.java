package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerReposotory extends CrudRepository<Customer, Long> {
	
	Optional<Customer>findByEmail(String email);
	//method naming standard 
	//findBy with element name as it is 

}
