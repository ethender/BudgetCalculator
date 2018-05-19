package org.hawk.dao;

import java.util.List;

import org.hawk.model.Transaction;
import org.hawk.utils.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("transactionDAO")
public class TransactionDAO {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Transaction create(Transaction obj) {
		System.out.println("comming to Transaction DAO");
		Session session = Util.getSession(sessionFactory);
		session.save(obj);
		return obj;
	}
	
	public Transaction update(Transaction obj) {
		Session session = Util.getSession(sessionFactory);
		Query query = session.createQuery("update Transaction set amount=:a,description=:d,transtime=:t,category=:c where transid=:i");
		query.setParameter("a", obj.getAmount());
		query.setParameter("d", obj.getDesc());
		query.setParameter("t", obj.getTranstime());
		query.setParameter("c", obj.getCategory());
		query.setParameter("i", obj.getTransid());
		
		int status  = query.executeUpdate();
		System.out.println("Update Transaction Status: "+status);
		return obj;
	}
	
	
	public List<Transaction> queryTransaction(String hqlQuery){
		Session session = Util.getSession(sessionFactory);
		Query  query = session.createQuery(hqlQuery);
		return query.list();
	}
}
