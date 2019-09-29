package com.receipe.book.ReceipeBook.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.receipe.book.ReceipeBook.model.Invoice;

public interface InvoiceDao extends JpaRepository<Invoice, Integer>{

@Modifying
	@Query(" UPDATE Invoice inv set inv.billto = :billto, inv.invoicenumber=:invoicenumber, "
			+ "inv.billingamount=:billingamount , inv.issuancedate=:issuancedate where inv.invoiceid=:invoiceid ")
	int updateInvoice(@Param("billto") String billto, @Param("invoicenumber") String invoicenumber,
			@Param("billingamount") Integer billingamount, @Param("issuancedate") LocalDate issuancedate, @Param("invoiceid") Integer invoiceid
			);

@Modifying
@Query("UPDATE Invoice inv set inv.billto = :billto, inv.branchname=:branchname,inv.ifsccode=:ifsccode,"
		+ "inv.accountnumber=:accountnumber, inv.bankname=:bankname where inv.invoiceid=:invoiceid")
int updateInvoiceCollect(@Param("billto")String billto, @Param("branchname")String branchname, 
		@Param("ifsccode")String ifsccode,
		@Param("accountnumber")String accountnumber, 
		@Param("bankname")String bankname, @Param("invoiceid")int invoiceid);


@Modifying
@Query("UPDATE Invoice inv set inv.billingamount = :billingamount where inv.invoiceid=:invoiceid")
int updateBillingAmount(@Param("billingamount") int i, @Param("invoiceid")int invoiceid);

@Modifying
@Query(nativeQuery =true,value =" Select * from Invoice where  issuance_flag = 0 and suspendflag = 0 and issuancedate > :issuancedate")
List<Invoice> findUnissued(@Param("issuancedate")LocalDate issuanceDate);
	
}
