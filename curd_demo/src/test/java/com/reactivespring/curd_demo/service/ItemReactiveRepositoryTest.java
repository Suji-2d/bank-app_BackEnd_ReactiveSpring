//package com.reactivespring.curd_demo.service;
//
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.reactivespring.curd_demo.repository.ItemReactiveRepository;
//
//import document.Item;
//import reactor.core.publisher.Flux;
//import reactor.test.StepVerifier;
//
//@DataMongoTest
//@RunWith(SpringRunner.class)
//public class ItemReactiveRepositoryTest {
//	
//	@Autowired
//	ItemReactiveRepository itemReactiveRepository;
//	
//	String null1 = null;
//	
//	
//	List<Item> itemList = Arrays.asList
//			(new Item(null1,"one plus TV",65000.0),
//			new Item(null1,"apple watch",45000.0),
//			new Item(null1,"samsung buds",10000.0));
//	
//	@Before
//	public void setup() {
//		System.out.println("ERROR");
//		itemReactiveRepository.deleteAll()
//				.thenMany(Flux.fromIterable(itemList))
//				.flatMap( itemReactiveRepository::save)
//				.doOnNext((item -> {
//					System.out.println("Inserted Item is : "+item);
//				}))
//				.blockLast();
//	
//	}
//	
//	@Test
//	public void getAllItems() {
//		System.out.println("ERRORT1");
//		StepVerifier.create(itemReactiveRepository.findAll())
//				.expectSubscription()
//				.expectNextCount(3)
//				.verifyComplete();
//	}
//	
//	@Test
//	public void findItemByDescription() {
//		
//		StepVerifier.create(itemReactiveRepository.findByDescription("samsung buds"))
//				.expectSubscription()
//				.expectNextCount(1)
//				.verifyComplete();
//	}
//}
