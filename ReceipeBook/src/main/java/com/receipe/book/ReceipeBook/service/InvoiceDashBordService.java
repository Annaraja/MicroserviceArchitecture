package com.receipe.book.ReceipeBook.service;

import java.util.List;
import java.util.Map;

import com.receipe.book.ReceipeBook.model.Invoice;
import com.receipe.book.ReceipeBook.model.InvoiceDetail;

public interface InvoiceDashBordService {

	Map<String,List<Invoice>> getAllListInvoices();

	Invoice getInvoiceByid(int invoiceid);

	int updateInvoice(Map<String,String> values);

	int updateInvoiceCollect(Map<String, String> values);

	void updateInvoiceDetail(List<InvoiceDetail> invoiceDetail, int invoiceid);

	List<Invoice> issueInvoices(List<Integer> invoiceIdList);
	
}
