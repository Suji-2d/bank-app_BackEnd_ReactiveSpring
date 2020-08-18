package com.reactivespring.curd_demo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.*;

import com.reactivespring.curd_demo.repository.CustomerRepository;

import document.Customer;
import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {

	@Autowired
	CustomerRepository customerRepository;
	
	static ServerResponse notFound= ServerResponse.ok().build().block();
	
	//GET ALL
	public Mono<ServerResponse> getAllCustomer(ServerRequest serverRequest){
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(customerRepository.findAll().log(),Customer.class);			
	}
	
	//GET BY USERNAME
	@SuppressWarnings("deprecation")
	public Mono<ServerResponse> getCustomerByUsername(ServerRequest serverRequest){
		
		String userName= serverRequest.pathVariable("userName");
		Mono<Customer> customerMono = customerRepository.findByUserName(userName);
	
//		return customerMono
//				.flatMap(cust->
//					 ServerResponse.ok()
//					.contentType(MediaType.APPLICATION_JSON)
//					.body(BodyInserters.fromObject(cust)))
//				.switchIfEmpty(notFound);	
			
		return 	ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(customerMono.log("Get By USERNAME :"),Customer.class);					
		
	}
	
	
	//CREATE 
	public Mono<ServerResponse> createCustomer(ServerRequest serverRequest){
		Mono<Customer> customer=serverRequest.bodyToMono(Customer.class);
		
		return  customer.flatMap(cust->ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(customerRepository.save(cust),Customer.class));
	}
	
	//UPDATE BY ID
	public Mono<ServerResponse> updateCustomerById(ServerRequest serverRequest){
		
		String id = serverRequest.pathVariable("id");
		Mono<Customer> customer =customerRepository.findById(id);
					
		Mono<Customer> updatedCust = serverRequest.bodyToMono(Customer.class)
					.flatMap( cust -> {
						
					Mono<Customer> actualCust = customer.flatMap(currentCust->{
							currentCust=cust;
							return customerRepository.save(currentCust);
						});
					
					return actualCust;
					});
		
		return updatedCust.flatMap( upCust -> 
									ServerResponse.ok()
									.contentType(MediaType.APPLICATION_JSON)
									.body(upCust,Customer.class));		
					
	}
	
	//UPDATE
	public Mono<ServerResponse> updateCustomer(ServerRequest serverRequest){
		Mono<Customer> customer=serverRequest.bodyToMono(Customer.class);
					
					return  customer.flatMap(cust->ServerResponse.ok()
							.contentType(MediaType.APPLICATION_JSON)
							.body(customerRepository.save(cust),Customer.class));
	}
	
	//DELETE
	public Mono<ServerResponse> deleteCustomer(ServerRequest serverRequest){
		String userName=serverRequest.pathVariable("id");
		
		Mono<Void> deleteCustomer = customerRepository.deleteById(userName);
		
		return  ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(deleteCustomer,void.class);
	}
}
