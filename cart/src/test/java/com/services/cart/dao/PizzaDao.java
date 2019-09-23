package com.services.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.cart.entity.City;

public interface PizzaDao extends JpaRepository<City, Integer>{

}
