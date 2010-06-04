/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

import java.io.Serializable;
import java.util.List;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public interface ILoggedUser {
    public List<User> getAllUsers();
    public User getUserByUserName(String username);
    public User getUserById(Serializable id);
    public User getFirst();
    public void addUser(User ub);
    public void remove();
}
