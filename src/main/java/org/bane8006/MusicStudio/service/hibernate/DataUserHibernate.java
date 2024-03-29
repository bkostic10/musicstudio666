/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service.hibernate;

import java.io.Serializable;
import java.util.List;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.User;
import org.hibernate.Session;

/**
 *
 * @author Baxter
 */
public class DataUserHibernate implements IDataUserService{
    private final Session session;

    public DataUserHibernate(Session session) {
        this.session = session;
    }

    
    public List<User> getAllUsers() {
        List all = session.createQuery("from UserBean").list();
        return all;
    }

    
    public User getUserByUserName(Serializable id) {
        return (User) session.get(UserBean.class, id);
    }

    
    public User addUser(User ub) {
        return (User)session.get(UserBean.class, session.save(ub));
    }

    
    public void replace(Serializable id, User b) {
        User u = (User) session.get(UserBean.class, id);
        u.setFirstName(b.getFirstName());
        u.setLastName(b.getLastName());
        u.setPersonalNumber(b.getPersonalNumber());
        u.setUserName(b.getUserName());
        u.setPassword(b.getPassword());
        u.setPrivilege(b.getPrivilege());
    }
    
    public void remove(User b) {
        long a = b.getIdUser();
        b = (User) session.load(UserBean.class, a);
        session.delete(b);
    }

    
    public User authenticate(String userName, String password) {
        for (int i = 0; i < getAllUsers().size(); i++) {
            if(getAllUsers().get(i).getUserName().equals(userName)&&getAllUsers().get((int) i).getPassword().equals(password)){
                return getAllUsers().get(i);
            }
        }
        return null;
    }

}
