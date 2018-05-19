package org.hawk.dao;

import java.util.List;

import org.hawk.model.User;
import org.hawk.utils.Util;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public User saveUser(User user) {
		Session session  =  Util.getSession(sessionFactory);
		System.out.println("Session Created: "+session.isConnected());
		session.save(user);
		
		return user;
	}
	
	public User updateUser(User user) {
		Session session  = Util.getSession(sessionFactory);
		Query query = session.createQuery("update User set email=:e where userid=:i");
		query.setParameter("e", user.getEmail());
		query.setParameter("i", user.getUserId());
		int status = query.executeUpdate();
		System.out.println("Update Status: for "+user.getUserId()+", code:"+status);
		return user;
	}
	
	
	public List<User> allUsers() {
		Session session = Util.getSession(sessionFactory);
		Query query = session.createQuery("from User");
		List users =  query.list();
		return users;
	}
	
	
	public List<User> queryUser(User user){
		Session session  =  Util.getSession(sessionFactory);
		Query query = session.createQuery("from User where username=:n");
		query.setParameter("n", user.getUsername());
		List<User> users = query.list();
		return users;
	}
	
	
	
}
