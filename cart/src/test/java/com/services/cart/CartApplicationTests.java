package com.services.cart;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.services.cart.dao.PizzaDao;
import com.services.cart.entity.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartApplicationTests {

	@Autowired
	private PizzaDao dao;
	
	@Test
	public void contextLoads() {
	
		Optional<City> p1=dao.findById(1);
	System.out.println(p1.get());
	}

}
