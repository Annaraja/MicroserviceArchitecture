package com.receipe.book.ReceipeBook.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.receipe.book.ReceipeBook.model.InvoiceDetailMode;

public class UpdateDetailPreparedStatementSetter implements
		BatchPreparedStatementSetter {
	
	
	List<InvoiceDetailMode> invoiceDetailModellist;
	
	UpdateDetailPreparedStatementSetter(List<InvoiceDetailMode> invoiceDetailModellist){
		this.invoiceDetailModellist=invoiceDetailModellist;
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(1, invoiceDetailModellist.get(i).getQuantity());
		ps.setInt(2, invoiceDetailModellist.get(i).getUnitprice());
		ps.setString(3, invoiceDetailModellist.get(i).getItem());
		ps.setInt(4, invoiceDetailModellist.get(i).getPrice());
		ps.setInt(5, invoiceDetailModellist.get(i).getRowno());
		ps.setInt(6, invoiceDetailModellist.get(i).getInvoiceid());
	}

	@Override
	public int getBatchSize() {
		return this.invoiceDetailModellist.size();
	}

}
