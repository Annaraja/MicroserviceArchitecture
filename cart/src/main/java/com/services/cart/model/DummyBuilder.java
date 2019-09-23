package com.services.cart.model;

public class DummyBuilder {
	public DummyBuilder id(int id){
		this.id=id;
		return this;
	}
	private int id;
	private String name;
	
	public DummyBuilder name(String name){
		this.name=name;
		return this;
	}
	public Dummy build(){
		return new Dummy(id,name);
	}
}
