package org.hawk.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Util {

	
	public static Session getSession(SessionFactory factory) {
		Session  temp = null;
		try {
			temp = factory.getCurrentSession();
		}catch(HibernateException ex) {
			System.err.println("No Current Session. Opening One");
			temp = factory.openSession();
		}
		
		return temp;
	}
}
