package com.receipe.book.ReceipeBook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.receipe.book.ReceipeBook.authentication.Account;
import com.receipe.book.ReceipeBook.authentication.AccountUserDetailService;
import com.receipe.book.ReceipeBook.model.Receipe;
import com.receipe.book.ReceipeBook.service.ReceipeBookService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/receipeBook")
public class ReceipeBookController {

	@Autowired
	private ReceipeBookService receipeBookService;
	
	
	
	@RequestMapping(value="/updateAllReceipes",method=RequestMethod.PUT,produces="application/json")
	public List<Receipe> updateAllReceipes(@RequestBody List<Receipe> receipes){
	return receipeBookService.updateAllReceipes(receipes);
	}
	
	@RequestMapping(value="/fetchAll",method=RequestMethod.GET)
	public List<Receipe> getAll(){
	return receipeBookService.fetchAll();
	}
	
      @RequestMapping(value="/publishes",method=RequestMethod.GET)
      public String openMode(){
    	  return "You are in not restricted mode";
      }
      
      
}
