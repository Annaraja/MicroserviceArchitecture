package com.receipe.book.ReceipeBook.dao;

import java.util.List;

import com.receipe.book.ReceipeBook.model.InvoiceDetail;
import com.receipe.book.ReceipeBook.model.InvoiceDetailMode;

public interface InvoiceDetailDao {

	
	
	void updateDetail(List<InvoiceDetailMode> list);

	void issueInvoices(List<Integer> invoiceIdList);
	
}
