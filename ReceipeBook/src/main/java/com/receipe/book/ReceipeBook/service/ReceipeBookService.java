package com.receipe.book.ReceipeBook.service;

import java.util.List;

import com.receipe.book.ReceipeBook.model.Receipe;

public interface ReceipeBookService {

	List<Receipe> updateAllReceipes(List<Receipe> receipes);

	List<Receipe> fetchAll();

}
