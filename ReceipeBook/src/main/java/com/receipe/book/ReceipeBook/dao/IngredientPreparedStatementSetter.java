package com.receipe.book.ReceipeBook.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.receipe.book.ReceipeBook.model.Ingredient;

public class IngredientPreparedStatementSetter implements BatchPreparedStatementSetter{
List<Ingredient> Ingredients;
	
	
	public IngredientPreparedStatementSetter(List<Ingredient> ingredients2) {
this.Ingredients=ingredients2;
}

	@Override
	public int getBatchSize() {
		return Ingredients.size();
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		ps.setString(1, Ingredients.get(i).getName());
		ps.setInt(2, Ingredients.get(i).getAmount());
	}

}
