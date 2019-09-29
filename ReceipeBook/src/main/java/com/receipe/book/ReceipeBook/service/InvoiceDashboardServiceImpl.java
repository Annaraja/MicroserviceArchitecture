package com.receipe.book.ReceipeBook.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;








import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;












import com.receipe.book.ReceipeBook.dao.InvoiceDao;
import com.receipe.book.ReceipeBook.dao.InvoiceDetailDao;
import com.receipe.book.ReceipeBook.model.Invoice;import com.receipe.book.ReceipeBook.model.InvoiceDetail;
import com.receipe.book.ReceipeBook.model.InvoiceDetailMode;
import com.receipe.book.ReceipeBook.model.IssuanceStatus;


public class InvoiceDashboardServiceImpl implements InvoiceDashBordService {


	@Autowired
	private InvoiceDao invoiceDao;
	
	@Autowired
	private InvoiceDetailDao detailDao;

	@Override
	public Map<String,List<Invoice>> getAllListInvoices() {
		Map<String,List<Invoice>>	invoicesMap=new HashMap<>();
		List<Invoice> invoiceList=	invoiceDao.findAll();
		List<Invoice> delayedInvoice=new ArrayList<>();
		List<Invoice> waitingForConfirmationInvoices=new ArrayList<>();
		List<Invoice> suspendedInvoice=new ArrayList<>();
		List<Invoice> confirmedInvoices=new ArrayList<>();
		invoiceList.stream().forEach(invoice->{
			if(invoice.isSuspendflag()){
				suspendedInvoice.add(invoice);
			}else if(LocalDate.now().toEpochDay()>invoice.getIssuancedate().toEpochDay() &&
					invoice.getIssuanceFlag().getStatus() ==0){
				delayedInvoice.add(invoice);
			}else if(invoice.getIssuanceFlag().getStatus() ==0){
				waitingForConfirmationInvoices.add(invoice);
			}else if(invoice.issuanceFlag.getStatus()==1)
				confirmedInvoices.add(invoice);
		});
		invoicesMap.put("suspened", suspendedInvoice);
		invoicesMap.put("delayed",delayedInvoice);
		invoicesMap.put("waiting", waitingForConfirmationInvoices);
		invoicesMap.put("confirmed", confirmedInvoices);
		invoicesMap.put("allInvoices", invoiceList);
		return invoicesMap;
	}

	@Override
	public Invoice getInvoiceByid(int invoiceid) {
		return invoiceDao.findById(invoiceid).get();
	}

	@Transactional
	@Override
	public int updateInvoice(Map<String, String> values) {
		String billto=values.get("billto");
		String invoicenumber=values.get("invoicenumber");
		String billingamount=values.get("billingamount");
		String invoiceid=values.get("invoiceid");
		String issuanceDate=values.get("issuancedate");
		String[] dates= issuanceDate.split("-");
		System.out.println(dates);
		LocalDate issuancedate = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
		return invoiceDao.updateInvoice(billto, invoicenumber, Integer.parseInt(billingamount), issuancedate,  Integer.parseInt(invoiceid));

	}

	@Transactional
	@Override
	public int updateInvoiceCollect(Map<String, String> values) {
		String billto=values.get("billto");
		String branchname=values.get("branchname");
		String ifsccode=values.get("ifsccode");
		String invoiceid=values.get("invoiceid");
		String accountnumber=values.get("accountnumber");
		String bankname=values.get("accountnumber");
		invoiceDao.updateInvoiceCollect(billto, branchname, ifsccode, accountnumber,bankname, Integer.parseInt(invoiceid));
		return 0;
	}

	@Transactional
	@Override
	public void updateInvoiceDetail(List<InvoiceDetail> invoiceDetail,
			int invoiceid) {
		AtomicInteger billingAmount=new AtomicInteger();
		List<InvoiceDetailMode> invoiceDetailModel=invoiceDetail.stream().map(mapper->{
			InvoiceDetailMode invModel=new InvoiceDetailMode();
			invModel.setItem(mapper.getItem());
			invModel.setPrice(mapper.getPrice());
			billingAmount.addAndGet(mapper.getPrice());
			invModel.setQuantity(mapper.getQuantity());
			invModel.setRowno(mapper.getRowno());
			invModel.setUnitprice(mapper.getUnitprice());
			invModel.setInvoiceid(invoiceid);
			return invModel;
		}).collect(Collectors.toList());
		
		detailDao.updateDetail(invoiceDetailModel);
		invoiceDao.updateBillingAmount(billingAmount.get(),invoiceid);
	}

	@Transactional
	@Override
	public List<Invoice> issueInvoices(List<Integer> invoiceIdList) {
		detailDao.issueInvoices(invoiceIdList);
		List<Invoice> invoiceIdsList= invoiceDao.findUnissued(LocalDate.now());
		for(Invoice inv:invoiceIdsList)
			System.out.println(inv);
		return invoiceIdsList;
	}

}
