package demo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountUserDetailService implements UserDetailsService{

	@Autowired
 private AccountDao dao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Account account=dao.findByUsername(username);
		if(account ==null)
			throw new UsernameNotFoundException("User Not found");
		AccountPrincipal acp=new AccountPrincipal(account);
		return acp;
	}

}
