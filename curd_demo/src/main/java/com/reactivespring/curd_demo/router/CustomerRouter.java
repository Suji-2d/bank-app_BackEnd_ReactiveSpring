package com.reactivespring.curd_demo.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.reactivespring.curd_demo.handler.CustomerHandler;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
@Configuration
@EnableWebFlux
public class CustomerRouter implements WebFluxConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("*");

		// Add more mappings...
	}
	
	@Bean
	public RouterFunction<ServerResponse> customerRoute(CustomerHandler customerHandler){
		return RouterFunctions
				.route(GET("/customer").and(accept(MediaType.APPLICATION_JSON))
						,customerHandler::getAllCustomer)
				.andRoute(GET("/customer/{userName}").and(accept(MediaType.APPLICATION_JSON))
						,customerHandler::getCustomerByUsername)
				.andRoute(POST("/customer").and(accept(MediaType.APPLICATION_JSON))
						,customerHandler::createCustomer)
				.andRoute(PUT("/customer/{id}").and(accept(MediaType.APPLICATION_JSON))
						,customerHandler::updateCustomerById)
				.andRoute(PUT("/customer").and(accept(MediaType.APPLICATION_JSON))
						,customerHandler::updateCustomer)
				.andRoute(DELETE("/customer/{id}").and(accept(MediaType.APPLICATION_JSON))
						,customerHandler::deleteCustomer);
	}
}
