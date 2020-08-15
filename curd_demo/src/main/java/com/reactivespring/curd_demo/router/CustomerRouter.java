package com.reactivespring.curd_demo.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.reactivespring.curd_demo.handler.CustomerHandler;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
@Configuration
public class CustomerRouter {
	
	@Bean
	public RouterFunction<ServerResponse> customerRoute(CustomerHandler customerHandler){
		return RouterFunctions
				.route(GET("/customer").and(accept(MediaType.APPLICATION_JSON))
						,customerHandler::getAllCustomer);
	}

}
