package com.receipe.book.ReceipeBook.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.receipe.book.ReceipeBook.dao.InvoiceDetailDao;
import com.receipe.book.ReceipeBook.dao.InvoiceDetailDaoImpl;
import com.receipe.book.ReceipeBook.dao.ReceipeBookJdbcDao;
import com.receipe.book.ReceipeBook.dao.ReceipeBookJdbcDaoImpl;

@Configuration
public class DaoConfig {

	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public ReceipeBookJdbcDao receipeBookJdbcDao(){
		return new ReceipeBookJdbcDaoImpl();
	}
	
	
	
	@Bean
	public InvoiceDetailDao invoiceDetailDao(){
		return new InvoiceDetailDaoImpl();
	}
	

}
