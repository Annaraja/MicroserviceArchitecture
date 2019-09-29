package com.receipe.book.ReceipeBook;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.receipe.book.ReceipeBook.dao.InvoiceDao;
import com.receipe.book.ReceipeBook.dao.ReceipeBookJdbcDao;
import com.receipe.book.ReceipeBook.model.Invoice;
import com.receipe.book.ReceipeBook.model.InvoiceDetail;
import com.receipe.book.ReceipeBook.model.IssuanceStatus;
import com.receipe.book.ReceipeBook.service.InvoiceDashBordService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceipeBookApplicationTests {

	
	@Autowired
	InvoiceDao invoiceDao;
	
	@Autowired
	InvoiceDashBordService invoiceDashBordService;
	
	@Test
	public void contextLoads() {
		
		List<Invoice> invoiceList=new ArrayList<>();
		for(int i=41;i<80;i++){
			Invoice l = new Invoice();
			l.setInvoiceid(i);
			l.setBillto("User "+i);
			l.setCurrencycode("INR");
			l.setLocation("Chennai");
			l.setInvoicenumber("12334"+i);
			boolean suspendflag = i%3 ==0?true:false;
			int year=2019;
			if(i%4==0) year=2018;
			
			if(i%5!=0)
				l.setIssuanceFlag(IssuanceStatus.WAITINGFORCONFIRMATION);
			else
			l.setIssuanceFlag(IssuanceStatus.CONFIRMED);
			System.out.println(l.getIssuanceFlag());
			if(suspendflag)
				l.setSuspensionreason("Reason "+i);
			LocalDate ld=LocalDate.of(year, 12,12);
			l.setIssuancedate(ld);
			System.out.println(l.getIssuancedate());
			l.setSuspendflag(suspendflag);
			l.setBillingamount(2);
			List<InvoiceDetail> detail=new ArrayList<>();
			int total=0;
			for(int j=1;j<6;j++){
				InvoiceDetail d=new InvoiceDetail();
				d.setRowno(j);
				d.setPrice(j*j);
				d.setQuantity(j);
				d.setUnitprice(j);
				total=total+d.getPrice();
			d.setItem("item "+j);
				detail.add(d);
			}
			l.setInvoiceDetail(detail);
			l.setDescription("Descrip "+i);
			l.setAccountnumber("501006080"+i);
			l.setIfsccode("HDFC000500");
			l.setBankname("HDFC");
			l.setCountrycode("IND");
			l.setBranchname("kotivakam");
			l.setBillingamount(total);
			invoiceList.add(l);
		}
		
		
		
	invoiceDao.saveAll(invoiceList);
	
/*	List<Invoice> ivs=	invoiceDashBordService.issueInvoices(Arrays.asList(3,4,5,7));
	ivs.stream().forEach( (data)->System.out.println(data)); */
	}

}
