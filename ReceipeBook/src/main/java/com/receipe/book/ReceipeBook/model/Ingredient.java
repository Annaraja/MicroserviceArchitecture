package com.receipe.book.ReceipeBook.model;

import javax.persistence.Embeddable;

@Embeddable
public class Ingredient {
private String name;
private int amount;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAmount() {
	return amount;
}
public void setAmount(int number) {
	this.amount = number;
}

}
