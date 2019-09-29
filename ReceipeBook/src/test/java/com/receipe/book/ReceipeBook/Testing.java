package com.receipe.book.ReceipeBook;

import java.time.LocalDate;

import com.receipe.book.ReceipeBook.model.Invoice;
import com.receipe.book.ReceipeBook.model.IssuanceStatus;

public class Testing {
public static void main(String args[]){
	
	Invoice i=new Invoice();
	i.setIssuanceFlag(IssuanceStatus.CONFIRMED);
	System.out.println(i.getIssuanceFlag());
	System.out.println(i.getIssuanceFlag().getStatus());
	i.setIssuanceFlag(IssuanceStatus.valueOf("WAITINGFORCONFIRMATION"));
	System.out.println(i.getIssuanceFlag());
	System.out.println(i.getIssuanceFlag().getStatus());
	System.out.println(LocalDate.now().toString());
	
}
}
