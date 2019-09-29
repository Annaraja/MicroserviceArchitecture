package com.receipe.book.ReceipeBook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.receipe.book.ReceipeBook.model.Invoice;
import com.receipe.book.ReceipeBook.model.InvoiceDetail;
import com.receipe.book.ReceipeBook.service.InvoiceDashBordService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceDashBordService invoiceDashBordService;
	
	@RequestMapping(value="getAllInvoices",method=RequestMethod.GET)
	public Map<String,List<Invoice>> getAllInvoices(){
		return invoiceDashBordService.getAllListInvoices();
		
	}
	
	@RequestMapping(value="/getInvoiceById",method=RequestMethod.GET)
	public Invoice getInvoiceById(@RequestParam String invoiceId){
		return invoiceDashBordService.getInvoiceByid(Integer.parseInt(invoiceId));
		
	}
	
	@RequestMapping(value="/updateInvoice",method=RequestMethod.POST,produces="application/json")
	public int updateInvoice(@RequestBody Map<String,String> values){
		return invoiceDashBordService.updateInvoice(values);
	}
	
	@RequestMapping(value="/updateInvoiceCollect",method=RequestMethod.POST,produces="application/json")
	public int updateInvoiceCollect(@RequestBody Map<String,String> values){
		return invoiceDashBordService.updateInvoiceCollect(values);
	}
	
	@RequestMapping(value="/updateInvoiceDetail",method=RequestMethod.POST,produces="application/json")
	public void updateInvoiceDetail(@RequestBody List<InvoiceDetail> invoiceDetail, @RequestParam String invoiceid){
		invoiceDashBordService.updateInvoiceDetail(invoiceDetail,Integer.parseInt(invoiceid));
	}
	
	
	@RequestMapping(value="/issueInvoices",method=RequestMethod.POST)
	public List<Invoice> issueInvoices(@RequestBody List<Integer> invoiceIdList){
	return	invoiceDashBordService.issueInvoices(invoiceIdList);
	}
	
	
}
