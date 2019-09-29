package com.receipe.book.ReceipeBook.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.receipe.book.ReceipeBook.dao.ReceipeBookDao;
import com.receipe.book.ReceipeBook.dao.ReceipeBookJdbcDao;
import com.receipe.book.ReceipeBook.model.Receipe;

public class ReceipeBookServiceImpl implements ReceipeBookService{

	@Autowired
	private ReceipeBookDao dao;
	
	@Autowired
	private ReceipeBookJdbcDao jbdcDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public List<Receipe> updateAllReceipes(List<Receipe> receipes) {
		jbdcDao.deleteAll();
		return dao.saveAll(receipes);
	}


	@Override
	public List<Receipe> fetchAll() {
		return dao.findAll();
	}

}
