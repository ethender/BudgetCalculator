package org.hawk.controllers;

import java.util.Date;

import org.hawk.model.Transaction;
import org.hawk.model.User;
import org.hawk.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TransactionController {

	@Autowired
	private TransactionService  transservice;
	
	
	
	
	@RequestMapping(path="/trans",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Object createUser(@RequestBody Transaction trans) {
		
		if(trans.getTranstime() == null) {
			trans.setTranstime(new Date());
		}
		System.out.println("Trans:"+trans);
		return transservice.createTransaction(trans);
	}

	
	@RequestMapping(path="/trans",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Object updateUser(@RequestBody Transaction trans) {
		return transservice.updateTransaction(trans);
	}
	
	@RequestMapping(path="/trans/{userid}",method=RequestMethod.GET,produces="application/json")
	public Object getUser(@PathVariable int userid) {
		Transaction trans = new Transaction();
		trans.setUserid(userid);
		return transservice.getUserTransactions(trans);
	}
	
	
	@RequestMapping(path="/trans/{userid}/{month}/{year}",method=RequestMethod.GET,produces="application/json")
	public Object getUser(@PathVariable int userid, @PathVariable String month,@PathVariable int year) {
		int mon  = getMonthNumber(month);
		System.out.println("Userid: "+userid+"For Month: "+month+":"+mon+",Year:"+year);
		return transservice.getUserMonthTransactions(userid, mon, year);
	}
	
	
	private int getMonthNumber(String month) {
		month = month.toLowerCase();
		if(month.equals("jan") || month.equals("")) {
			return 1;
		}else if(month.equals("feb") || month.equals("february")) {
			return 2;
		}else if(month.equals("mar") || month.equals("march")) {
			return 3;
		}else if(month.equals("april") || month.equals("apr")) {
			return 4;
		}else if(month.equals("may")) {
			return 5;
		}else if(month.equals("jun") || month.equals("june")) {
			return 6;
		}else if(month.equals("jul") || month.equals("july")) {
			return 7;
		}else if(month.equals("aug") || month.equals("august")) {
			return 8;
		}else if(month.equals("sep") || month.equals("september")) {
			return 9;
		}else if(month.equals("oct") || month.equals("october")) {
			return 10;
		}else if(month.equals("nov") || month.equals("november")){
			return 11;
		}else {
			return 12;
		}
			
	}
	
	
	@RequestMapping(path="/alltrans",method=RequestMethod.GET,produces="application/json")
	public Object getUser() {
		return transservice.allTransactions();
	}
	
}
