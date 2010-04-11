/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

import java.io.Serializable;
import java.util.List;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public interface IDataUserService {
    public List<User> getAllUsers();
    public User getUserByUserName(Serializable id);
    @CommitAfter
    public User addUser(User ub);
    @CommitAfter
    public void replace(Serializable b2,User b);
    @CommitAfter
    public void remove(User b);
    public User authenticate(String userName,String password);
}
