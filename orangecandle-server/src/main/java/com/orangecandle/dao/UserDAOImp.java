package com.orangecandle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.orangecandle.domain.User;
@Repository
public class UserDAOImp implements UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImp.class);
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
	@Override
	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("User saved successfully, adding User is "+p);
	}

	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, adding User is "+p);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList=session.createQuery("from User").list();
		for(User u:userList){
			logger.info("User : "+u);
		}
		logger.info("User saved successfully");
		return userList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u=(User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, adding user is "+u);
		return u;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u=(User) session.load(User.class, new Integer(id));
		if(u!=null){
			session.delete(u);
		}
			logger.info("User deleted successfully, adding user is "+u);		
	}

}
