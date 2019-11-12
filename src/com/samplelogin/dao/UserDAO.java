package com.samplelogin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.samplelogin.model.User;

public class UserDAO {
	//static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public boolean createUser(User user) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return true;
	}

	public User getUser(String username) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> userResults = session.createQuery("FROM User where user_name='" + username+"'").list();
		session.close();
		return userResults.get(0);
		
	
	}

}
