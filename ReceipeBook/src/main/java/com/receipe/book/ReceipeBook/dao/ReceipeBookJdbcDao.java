package com.receipe.book.ReceipeBook.dao;

import java.util.List;

import com.receipe.book.ReceipeBook.model.Receipe;


public interface ReceipeBookJdbcDao  {
	public List<Receipe> update(List<Receipe> receipes);
	public void deleteAll();
}
