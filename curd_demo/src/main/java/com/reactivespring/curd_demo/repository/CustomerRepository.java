package com.reactivespring.curd_demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CustomerRepository extends ReactiveMongoRepository<Customer,String>{
	
	Mono<Customer> findByUserName(String userName); 
	Mono<Void> deleteByUserName(String userName); 
}
