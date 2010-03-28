/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.io.Serializable;
import java.util.List;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public interface IDataUser {
    public List<User> getAllUsers();
    public User getUserByUserName(Serializable id);
    @CommitAfter
    public User addUser(User ub);
    public void replace(User b2,User b);
    public void remove(User b);
    public User authenticate(String userName,String password);
}
