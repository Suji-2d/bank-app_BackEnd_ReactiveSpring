package com.reactivespring.curd_demo.initialize;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.reactivespring.curd_demo.repository.CustomerRepository;

import document.Customer;
import reactor.core.publisher.Flux;

@Component
public class CustomerCommandLineRunner implements CommandLineRunner{

	@Autowired
	CustomerRepository customerRepository;
	
	List<Customer> custList = Arrays.asList
			(new Customer(null,
					"Sujith Kannan",
					"suji2d",
					"pass",
					"suji@asd.com",
					"1234567890",
					"Frather",
					"Krish",
					"No.1, asdd, asdf street, qweeds",
					"Male",
					"single",
					"12/02/19967",
					"15/08/2020",
					"saving",
					"velc",
					"Indian",
					100000.0,
					"license",
					"23456"),
			 new Customer(null,
					"Benny",
					"ben10",
					"pass",
					"ben@asd.com",
					"1234567890",
					"Frnd",
					"suji",
					"No.1, asdd, asdf street, qweeds",
					"Male",
					"single",
					"12/02/19967",
					"15/08/2020",
					"saving",
					"velc",
					"Indian",
					100000.0,
					"license",
					"23456"));
	
	@Override
	public void run(String... args) throws Exception {
		intialize();	
	}

	
	public void intialize(){
		System.out.println("Customer Initialisation");
		customerRepository.deleteAll()
				.thenMany(Flux.fromIterable(custList))
					.flatMap(customerRepository::save)
					.thenMany(customerRepository.findAll())
					.subscribe(
							cust->System.out.println("Initialized :"+cust),
							error ->System.out.println(error)
							);		
	}
}
