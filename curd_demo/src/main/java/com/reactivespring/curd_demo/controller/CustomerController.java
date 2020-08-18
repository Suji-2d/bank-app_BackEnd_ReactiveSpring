package com.reactivespring.curd_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reactivespring.curd_demo.repository.CustomerRepository;

import document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/c1")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/customer/ok")
	public Mono<String> customerCheck(){
		return Mono.just("OK");
	}
	
	@GetMapping("/customer")
	public Flux <Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/customer/{userName}")
	public Mono <Customer> getCustomerByUserName(@PathVariable String userName){
		return customerRepository.findByUserName(userName);
	}
	
	@PostMapping("/customer")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono <Customer> createCustomer(@RequestBody Customer customer){
		return customerRepository.save(customer);
	}
	
	@PutMapping("/customer/{id}")
	public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable String id,
														 @RequestBody Customer customer){
		return customerRepository.findById(id)
					.flatMap(cust -> {
						cust=customer; //Also set particular value
						return 	customerRepository.save(cust);
					})
					.map(updateCust-> new ResponseEntity<>(updateCust,HttpStatus.OK))
					.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	public Mono <Void> deleteCustomerById(@PathVariable String id){
		return customerRepository.deleteById(id);
	}
	

}
