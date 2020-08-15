package com.reactivespring.curd_demo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactivespring.curd_demo.repository.CustomerRepository;

import document.Customer;
import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {

	@Autowired
	CustomerRepository customerRepository;
	
	public Mono<ServerResponse> getAllCustomer(ServerRequest serverRequest){
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(customerRepository.findAll().log(),Customer.class);			
	}
}
