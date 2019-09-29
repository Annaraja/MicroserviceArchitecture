package com.receipe.book.ReceipeBook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.receipe.book.ReceipeBook.model.Receipe;

public interface ReceipeBookDao extends JpaRepository<Receipe,Integer>{

	

}
