/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.List;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public interface IDataUser {
    public List<User> getAllUsers();
    public User getUserByUserName(String name);
    public void addUser(User ub);
    public void replace(User b2,User b);
    public void remove(User b);
    public User authenticate(String userName,String password);
}
