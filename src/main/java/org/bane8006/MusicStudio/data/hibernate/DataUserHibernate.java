/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data.hibernate;

import java.util.List;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class DataUserHibernate implements IDataUser{

    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public User getUserByUserName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addUser(User ub) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void replace(User b2, User b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove(User b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public User authenticate(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
