package com.receipe.book.ReceipeBook.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.receipe.book.ReceipeBook.model.Receipe;

public class ReceipeBookPreparedStatementSetter implements BatchPreparedStatementSetter{

	List<Receipe> receipes;
	
	
	public ReceipeBookPreparedStatementSetter(List<Receipe> receipes) {
		this.receipes=receipes;
	}

	@Override
	public int getBatchSize() {
		return receipes.size();
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		ps.setString(1, receipes.get(i).getTitle());
		ps.setString(2, receipes.get(i).getDescription());
		ps.setString(3, receipes.get(i).getImagePath());
		ps.setInt(4, receipes.get(i).getId());
	}

}
