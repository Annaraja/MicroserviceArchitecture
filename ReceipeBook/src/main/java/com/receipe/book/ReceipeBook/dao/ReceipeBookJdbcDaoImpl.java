package com.receipe.book.ReceipeBook.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.receipe.book.ReceipeBook.model.Ingredient;
import com.receipe.book.ReceipeBook.model.Receipe;

public class ReceipeBookJdbcDaoImpl implements ReceipeBookJdbcDao {

	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Receipe> update(List<Receipe> receipes) {
		System.out.println("updated");
	    String sql="Update Receipe set title =?,description =?,image_path=? where id= ?";
		int[] up=jdbc.batchUpdate(sql, new ReceipeBookPreparedStatementSetter(receipes));
		receipes.stream().forEach(action->{
			String ingSql="UPDATE receipe_ingredients set name=? ,amount= ? where receipe_id =";
			ingSql=ingSql+""+action.getId()+"";
			jdbc.batchUpdate(ingSql,new IngredientPreparedStatementSetter(action.getIngredients()));
		});
		return receipes;
	}

	
	@Override
	public void deleteAll() {
		jdbc.execute("DELETE FROM receipe_ingredients");
		jdbc.execute("DELETE FROM receipe");
		
	}
	
	
	
}
