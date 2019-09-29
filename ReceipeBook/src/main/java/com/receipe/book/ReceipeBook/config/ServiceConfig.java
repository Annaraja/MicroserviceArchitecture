package com.receipe.book.ReceipeBook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.receipe.book.ReceipeBook.service.InvoiceDashBordService;
import com.receipe.book.ReceipeBook.service.InvoiceDashboardServiceImpl;
import com.receipe.book.ReceipeBook.service.ReceipeBookService;
import com.receipe.book.ReceipeBook.service.ReceipeBookServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public ReceipeBookService receipeService(){
		return new ReceipeBookServiceImpl();
	}
	
	@Bean
	public InvoiceDashBordService  InvoiceDashbordService(){
		return new InvoiceDashboardServiceImpl();
	}
	
}
