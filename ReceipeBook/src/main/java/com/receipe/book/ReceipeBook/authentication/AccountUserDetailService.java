package com.receipe.book.ReceipeBook.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountUserDetailService implements UserDetailsService{

	@Autowired
 private AccountDao dao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		Account account=dao.findByEmail(email);
		if(account ==null)
			throw new UsernameNotFoundException("User Not found");
		AccountPrincipal acp=new AccountPrincipal(account);
		return acp;
	}
	
	public void createUser(String email,String password){
		String bcrypEncodedPassword=bCryptPasswordEncoder.encode(password);
		System.out.println(bcrypEncodedPassword);
		Account account =new Account();
		account.setEmail(email);
		account.setPassword(bcrypEncodedPassword);
		dao.save(account);
	}
	
 public boolean duplicateEmail(String email){
	 Account account=null;
	 account= dao.findByEmail(email);
	return account == null ? false:true;
 }
 
}
