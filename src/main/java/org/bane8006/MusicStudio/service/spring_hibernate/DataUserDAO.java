package org.bane8006.MusicStudio.service.spring_hibernate;

import java.io.Serializable;
import java.util.List;

import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class DataUserDAO implements IDataUserService {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional
	public User addUser(User ub) {
		// TODO Auto-generated method stub
		Long id = (Long) sessionFactory.getCurrentSession().save(ub);
		return  (User) sessionFactory.getCurrentSession().get(UserBean.class, id);
	}

	@Transactional
	public User authenticate(String userName, String password) {
		for (int i = 0; i < getAllUsers().size(); i++) {
            if(getAllUsers().get(i).getUserName().equals(userName)&&getAllUsers().get((int) i).getPassword().equals(password)){
                return getAllUsers().get(i);
            }
        }
        return null;
	}

	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List all = sessionFactory.getCurrentSession().createQuery("from UserBean").list();
        return all;
	}

	@Transactional
	public User getUserByUserName(Serializable id) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().get(UserBean.class, id);
	}

	@Transactional
	public void remove(User b) {
		// TODO Auto-generated method stub
		long a = b.getIdUser();
        b = (User) sessionFactory.getCurrentSession().load(UserBean.class, a);
        sessionFactory.getCurrentSession().delete(b);
	}

	@Transactional
	public void replace(Serializable b2, User b) {
		// TODO Auto-generated method stub
		User u = (User) sessionFactory.getCurrentSession().get(UserBean.class, b2);
        u.setFirstName(b.getFirstName());
        u.setLastName(b.getLastName());
        u.setPersonalNumber(b.getPersonalNumber());
        u.setUserName(b.getUserName());
        u.setPassword(b.getPassword());
        u.setPrivilege(b.getPrivilege());
	}

}
