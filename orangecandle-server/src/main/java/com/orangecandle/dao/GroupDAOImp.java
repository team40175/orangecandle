package com.orangecandle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.orangecandle.domain.Group;

@Repository
public class GroupDAOImp implements GroupDAO {
	private static final Logger logger = LoggerFactory.getLogger(GroupDAOImp.class);
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
	@Override
	public void addGroup(Group p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Group saved successfully, adding group is "+p);
	}
	public Group getGroup(int id){
		return null;
	}
	@Override
	public void updateGroup(Group p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Group updated successfully, adding group is "+p);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Group> listGroups() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Group> groupList=session.createQuery("from Group").list();
		for(Group g:groupList){
			logger.info("group : "+g);
		}
		logger.info("Group saved successfully");
		return groupList;
	}

	@Override
	public Group getGroupById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Group g=(Group) session.load(Group.class, new Integer(id));
		logger.info("Group loaded successfully, adding group is "+g);
		return g;
	}

	@Override
	public void removeGroup(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Group g=(Group) session.load(Group.class, new Integer(id));
		if(g!=null){
			session.delete(g);
		}
			logger.info("Group deleted successfully, adding group is "+g);		
	}

}
