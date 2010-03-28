/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.service.User;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Baxter
 */
public class DataUserHibernate implements IDataUser{
    private final Session session;

    public DataUserHibernate(Session session) {
        this.session = session;
    }

    public List<User> getAllUsers() {
        Criteria criteria = session.createCriteria(UserBean.class);
        return criteria.list();
    }

    public User getUserByUserName(Serializable id) {
        return (User) session.get(UserBean.class, id);
    }

    public User addUser(User ub) {
        return (User)session.get(UserBean.class, session.save(ub));
    }

    public void replace(User b2, User b) {
        //session.update((String) session.get(UserBean.class, b2.getUserName()),session.save(b));
    }

    public void remove(User b) {
        //session.delete(b.getUserName(), b);
    }

    public User authenticate(String userName, String password) {
        for (int i = 0; i < getAllUsers().size(); i++) {
            if(getAllUsers().get(i).getUserName().equals(userName)&&getAllUsers().get((int) i).getPassword().equals(password)){
                return getUserByUserName(i);
            }
        }
        return null;
    }

}
