package com.receipe.book.ReceipeBook.model;

public enum IssuanceStatus {

	WAITINGFORCONFIRMATION(0),
	CONFIRMED(1);
	
	private final int status;
	
	IssuanceStatus(int status){
		this.status=status;
	}
	
	public int getStatus(){
		return this.status;
	}

	
	
}
