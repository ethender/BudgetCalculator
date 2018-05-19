package org.hawk.service;

import java.util.List;

import org.hawk.dao.TransactionDAO;
import org.hawk.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<Transaction> allTransactions(){
		String query = "from Transaction";
		return transactionDAO.queryTransaction(query);
	}
	
	public List<Transaction> getUserMonthTransactions(int userid, int month, int year){
		String query = "from Transaction where userid="+userid+" and month(transtime)="+month+" and year(transtime)="+year;
		return transactionDAO.queryTransaction(query);
	}
	
	
	public List<Transaction> getUserTransactions(Transaction trans){
		String query = "from Transaction where userid='"+trans.getUserid()+"'";
		return transactionDAO.queryTransaction(query);
	}
}
