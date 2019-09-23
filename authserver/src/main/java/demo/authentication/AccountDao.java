package demo.authentication;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountDao  extends JpaRepository<Account, Integer>{

	
	Account findByUsername(String username);
	
}
