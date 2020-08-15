package com.reactivespring.curd_demo.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.reactivespring.curd_demo.repository.CustomerRepository;
import document.Customer;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@DataMongoTest
@RunWith(SpringRunner.class)
public class RouterAndHandlerTest {
		
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
		
		
		
		@BeforeAll
		public void setup() {
			System.out.println("ERROR");
			
			customerRepository.deleteAll()
			.thenMany(Flux.fromIterable(custList))
			.flatMap( customerRepository::save)
			.doOnNext((cust -> {
				System.out.println("Inserted cust is : "+cust);
			}))
			.blockLast();
		}
		
		@Test
		public void getAllItems() {
			System.out.println("ERRORT1");
			StepVerifier.create(customerRepository.findAll())
					.expectSubscription()
					.expectNextCount(2)
					.verifyComplete();
		}
		
//		@Test
//		public void findItemByDescription() {
//			
//			StepVerifier.create(itemReactiveRepository.findByDescription("samsung buds"))
//					.expectSubscription()
//					.expectNextCount(1)
//					.verifyComplete();
//		}
	}

