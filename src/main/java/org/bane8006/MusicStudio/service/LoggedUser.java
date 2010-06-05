/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public class LoggedUser implements ILoggedUser{

    private List<User> users;

    public LoggedUser(List<User> users) {
        super();
        this.users = users;
    }
    
    public LoggedUser() {
        this(new ArrayList<User>());
    }

    @Override
    public List<User> getAllUsers() {
        return  users;
    }

    @Override
    public User getUserByUserName(String name) {
         for(User ub:users){
            if(ub.getUserName().equals(name))
                return ub;
        }
        return null;
    }

    @Override
    public void addUser(User ub){
        users.add(ub);
    }

    @Override
    public void remove(User u){
        users.remove(u);
    }

    @Override
    public User getFirst() {
        return users.get(0);
    }

    @Override
    public User getUserById(Serializable id) {
         for(User ub:users){
            if(ub.getIdUser()==id)
                return ub;
        }
        return null;
    }

}
