package com.receipe.book.ReceipeBook.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		 .authorizeRequests (). antMatchers ("/oauth/token","/oauth/refresh", "/oauth/authorize **", 
				 "/receipeBook/publishes","/authority/signUp","/actuator"
				 ,"/authority/duplicateEmail"). permitAll ()
		  .anyRequest (). authenticated (); 
		 
	}

}
