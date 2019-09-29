package com.receipe.book.ReceipeBook.model;

import javax.persistence.Embeddable;

@Embeddable
public class InvoiceDetail {
	 
	    public int getRowno() {
		return rowno;
	}
	public void setRowno(int rowno) {
		this.rowno = rowno;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
		public int rowno;
	    public int quantity;
	    public int unitprice;
	    public int price;
	    public String item;
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		@Override
		public String toString() {
			return "InvoiceDetail [rowno=" + rowno + ", quantity=" + quantity
					+ ", unitprice=" + unitprice + ", price=" + price + "]";
		}
}
