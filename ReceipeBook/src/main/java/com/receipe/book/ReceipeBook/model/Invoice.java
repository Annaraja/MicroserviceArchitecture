package com.receipe.book.ReceipeBook.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Invoice")
public class Invoice {

	@Id
	public int invoiceid;
	
	public String billto ;
    public String invoicenumber;
    public LocalDate issuancedate;
    public int billingamount;
    public String currencycode;
    public boolean suspendflag;
    public String description;
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String suspensionreason;
    public IssuanceStatus getIssuanceFlag() {
		return issuanceFlag;
	}

	public void setIssuanceFlag(IssuanceStatus issuanceFlag) {
		this.issuanceFlag = issuanceFlag;
	}

	public String location;
    public String bankname;
    public String accountnumber;
    public String ifsccode;
    public String branchname;
    public IssuanceStatus issuanceFlag;
    public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String countrycode;
    
    @ElementCollection 
    public List<InvoiceDetail>invoiceDetail;

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public String getBillto() {
		return billto;
	}

	public void setBillto(String billto) {
		this.billto = billto;
	}

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public LocalDate getIssuancedate() {
		return issuancedate;
	}

	public void setIssuancedate(LocalDate issuancedate) {
		this.issuancedate = issuancedate;
	}

	public int getBillingamount() {
		return billingamount;
	}

	public void setBillingamount(int billingamount) {
		this.billingamount = billingamount;
	}

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public boolean isSuspendflag() {
		return suspendflag;
	}

	public void setSuspendflag(boolean suspendflag) {
		this.suspendflag = suspendflag;
	}

	public String getSuspensionreason() {
		return suspensionreason;
	}

	public void setSuspensionreason(String suspensionreason) {
		this.suspensionreason = suspensionreason;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceid=" + invoiceid + ", billto=" + billto
				+ ", invoicenumber=" + invoicenumber + ", issuancedate="
				+ issuancedate + ", billingamount=" + billingamount
				+ ", currencycode=" + currencycode + ", suspendflag="
				+ suspendflag + ", suspensionreason=" + suspensionreason
				+ ", location=" + location + ", bankname=" + bankname
				+ ", accountnumber=" + accountnumber + ", ifsccode=" + ifsccode
				+ ", countrycode=" + countrycode + ", invoiceDetail="
				+ invoiceDetail + "]";
	}

	public List<InvoiceDetail> getInvoiceDetail() {
		return invoiceDetail;
	}

	public void setInvoiceDetail(List<InvoiceDetail> invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}
    
}
