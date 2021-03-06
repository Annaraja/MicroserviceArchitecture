package com.receipe.book.ReceipeBook.authentication;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	
	@Autowired
	   private AuthenticationManager authenticationManager;
	 
	@Autowired
	   private TokenStore tokenStore;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AccountUserDetailService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	   public TokenStore tokenStore () {
	     return new InMemoryTokenStore ();
	//return new JdbcTokenStore(dataSources());   
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {
		endpoints
     .authenticationManager (authenticationManager)    
     .userDetailsService(userDetailsService)
     .tokenStore (tokenStore);
	}

	public DriverManagerDataSource dataSources(){
		DriverManagerDataSource DriverManagerDataSource =new DriverManagerDataSource();
		DriverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		DriverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/exercise");
		DriverManagerDataSource.setUsername("root");
		DriverManagerDataSource.setPassword("Annaraj1$");
		return DriverManagerDataSource;
	}
	
	
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
//		clients.jdbc(dataSource);
		clients.inMemory ()
	     .withClient ("client")
	             .authorizedGrantTypes ("password", "authorization_code", "refresh_token", "implicit")
	             .authorities ("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER")
	             .scopes ("read", "write")
	             .autoApprove (true)        
	             .secret (passwordEncoder. encode ("password")); 
	               
	}
	
	
//	@Bean
// public PasswordEncoder passwordEncoder () {
//     return new BCryptPasswordEncoder ();
// }
	
	
}
