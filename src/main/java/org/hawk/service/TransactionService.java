package org.hawk.service;

import java.util.Collections;
import java.util.List;

import org.hawk.dao.TransactionDAO;
import org.hawk.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hawk.model.*;

@Service("transservice")
@Transactional
public class TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;
	
	public Transaction createTransaction(Transaction trans) {
		System.out.println("comming to transaction service");
		return transactionDAO.create(trans);
	}
	
	public Transaction updateTransaction(Transaction trans) {
		return transactionDAO.update(trans);
	}
	
	public Transactions allTransactions(){
		String query = "from Transaction";
		List<Transaction> trans = transactionDAO.queryTransaction(query);
		Transactions allTrans = new Transactions();
		calculateTotalTransactions(trans,allTrans);
		return allTrans;
		
	}
	
	public Transactions getUserMonthTransactions(int userid, int month, int year){
		String query = "from Transaction where userid="+userid+" and month(transtime)="+month+" and year(transtime)="+year;
		List<Transaction> trans = transactionDAO.queryTransaction(query);
		Transactions allTrans = new Transactions();
		calculateTotalTransactions(trans,allTrans);
		return allTrans;
	}
	
	
	public Transactions getUserTransactions(Transaction trans){
		String query = "from Transaction where userid='"+trans.getUserid()+"'";
		List<Transaction> queryTrans =  transactionDAO.queryTransaction(query);
		Transactions allTrans = new Transactions();
		calculateTotalTransactions(queryTrans,allTrans);
		return allTrans;
	}
	
	
	
	private void calculateTotalTransactions(List<Transaction> list, Transactions finalTrans) {
		double amount = 0.0;
		double creditAmount = 0.0;
		double debitAmount = 0.0;
		int creditsTotal = 0;
		int debitsTotal = 0;
		for(Transaction t : list) {
			amount += t.getAmount();
			if(t.getTranstype().equalsIgnoreCase("debit") || t.getTranstype().equalsIgnoreCase("Debit") || t.getTranstype().equalsIgnoreCase("dr") || t.getTranstype().equalsIgnoreCase("Dr")) {
				debitAmount += t.getAmount();
				++debitsTotal;
			}else {
				creditAmount += t.getAmount();
				++creditsTotal;
			}
		}
		finalTrans.setTotal(amount);
		finalTrans.setCreditsCount(creditsTotal);
		finalTrans.setDebitsCount(debitsTotal);
		finalTrans.setDebitTotal(debitAmount);
		finalTrans.setCreditTotal(creditAmount);
		Collections.reverse(list);
		finalTrans.setTrans(list);
	}
	
	
	
	
}
