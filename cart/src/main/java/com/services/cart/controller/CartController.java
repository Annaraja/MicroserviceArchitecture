package com.services.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.services.cart.model.Dummy;
import com.services.cart.model.DummyBuilder;
@EnableHystrix
@RestController
@RequestMapping("/cart")
public class CartController {

	
	//@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private OAuth2RestTemplate oAuth2RestTemplate;
	
	
	@HystrixCommand(fallbackMethod = "retrieveSomethingFallback")
	@RequestMapping(value="/getAllValues",method=RequestMethod.GET,produces="application/json")
	public String getAllValues(){
		return "return all Values";
	}
	
	
	@RequestMapping(value="/hi",method=RequestMethod.GET,produces="application/json")
	public Dummy hi(){
		return new DummyBuilder().id(5).name("value").build();
	}
	
	@HystrixCommand(fallbackMethod = "retrieveSomethingFallback")
	@RequestMapping(value="/getAll",produces={"application/json"})
	public String getAll(){
		//byte[] decodedBytes = Base64.getDecoder().decode(password);
		String check=oAuth2RestTemplate.getForObject("http://greetings/greetings/current", String.class);
	//	String passwords=new String(decodedBytes);
		return check+" all "+" "+check;
	}
	public String retrieveSomethingFallback(){
		return "retrieveSomethingFallback";
	}
}
