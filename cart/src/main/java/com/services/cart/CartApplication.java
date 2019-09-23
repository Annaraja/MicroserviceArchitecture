package com.services.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@EnableCircuitBreaker
public class CartApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	@LoadBalanced
	public OAuth2RestTemplate oAuth2RestTemplate(
			OAuth2ClientContext OAuth2ClientContext,OAuth2ProtectedResourceDetails OAuth2ProtectedResourceDetails) {
		 OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(OAuth2ProtectedResourceDetails,OAuth2ClientContext);
	    return oAuth2RestTemplate;
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
	}

}
