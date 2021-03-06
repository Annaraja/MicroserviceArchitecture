package demo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{

	
private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService UserDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.parentAuthenticationManager(authenticationManager).userDetailsService(UserDetailsService)
		.passwordEncoder(passwordEncoder());
	
	}
	 public PasswordEncoder passwordEncoder () {
	        return new BCryptPasswordEncoder ();
	    }
	@Bean
    public AuthenticationManager authenticationManagerBean() 
      throws Exception {
        return super.authenticationManagerBean();
    }
}
