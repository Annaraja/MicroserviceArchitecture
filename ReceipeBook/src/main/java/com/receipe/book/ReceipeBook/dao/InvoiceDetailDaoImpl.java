package com.receipe.book.ReceipeBook.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.receipe.book.ReceipeBook.model.InvoiceDetail;
import com.receipe.book.ReceipeBook.model.InvoiceDetailMode;

public class InvoiceDetailDaoImpl implements InvoiceDetailDao {

	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void updateDetail(List<InvoiceDetailMode> list) {
		String sql=" UPDATE  invoice_invoice_detail set quantity=?, unitprice=? ,item =?, price=? where "
				+ "rowno=? and invoice_invoiceid=?";
		jdbc.batchUpdate(sql, new UpdateDetailPreparedStatementSetter(list));
	}

	@Override
	public void issueInvoices(List<Integer> invoiceIdList) {
		String sql= " UPDATE Invoice set  issuance_flag = 1 where invoiceid =?";
		jdbc.batchUpdate(sql, new IssueInvoicePss(invoiceIdList));
	}
	
	public class IssueInvoicePss implements
	BatchPreparedStatementSetter{
		List<Integer> invoiceIdList;
		
		public IssueInvoicePss(List<Integer> invoiceIdList) {
			this.invoiceIdList=invoiceIdList;
		}

		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
     ps.setInt(1, invoiceIdList.get(i));
		}

		@Override
		public int getBatchSize() {
			return this.invoiceIdList.size();
		}
		
	}
	
	
}
