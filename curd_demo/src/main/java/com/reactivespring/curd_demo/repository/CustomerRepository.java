package com.reactivespring.curd_demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import document.Customer;


public interface CustomerRepository extends ReactiveMongoRepository<Customer,String>{
		
}
