package com.receipe.book.ReceipeBook.authentication;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountDao  extends JpaRepository<Account, Integer>{

	
	Account findByEmail(String email);
	
}
