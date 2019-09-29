package com.receipe.book.ReceipeBook.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.receipe.book.ReceipeBook.authentication.AccountUserDetailService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/authority")
public class AuthorizationController {

	@Autowired
	private AccountUserDetailService userDetailsService;
	
	
	@RequestMapping(value="/signUp",method=RequestMethod.POST,produces="application/json")
    public void signUp(@RequestBody Map<String,String> userDetails){
  	 System.out.println(userDetails);
  	 userDetailsService.createUser(userDetails.get("email"),userDetails.get("password"));
    }
    
    @RequestMapping(value="/duplicateEmail",method=RequestMethod.POST)
    public boolean duplicateEmail(@RequestBody Map<String,String> userDetails){
		return userDetailsService.duplicateEmail(userDetails.get("email"));
    }
	
    @RequestMapping(value="/getCookie",method=RequestMethod.GET)
    public ResponseEntity<String> getCookie(HttpServletResponse httpServletResponse){
    	final Cookie cookie=new Cookie("user","annaraja");
    	cookie.setHttpOnly(true);
    	cookie.setMaxAge(6000);
    	httpServletResponse.addCookie(cookie);
    	return new ResponseEntity<String>(httpServletResponse.toString(),HttpStatus.OK);
    }
    
}
