/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.aints.User;

/**
 *
 * @author Baxter
 */
public class MockDataUser implements IDataUserService{

    private List<User> users;

    public MockDataUser(List<User> users) {
        super();
        this.users = users;
    }
    
    public MockDataUser() {
        this(new ArrayList<User>());
        addUser(new UserBean("Pera", "Pampur", "0706987483921", "admin", "admin",Privilege.Admin));
    }

    public List<User> getAllUsers() {
        return  users;
    }

    public User getUserByUserName(Serializable name) {
         for(User ub:users){
            if(ub.getUserName().equals(name))
                return ub;
        }
        return null;
    }
    public User addUser(User ub){
        if(!users.contains(ub)){
            assert ub.getUserName()!=null;
            assert ub.getUserName().length()>4;
            users.add(ub);
            return ub;
        }
        else return null;
    }
    public void replace(Serializable b2,User b){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(b2)){
                Privilege p = users.get(i).getPrivilege();
                users.remove(i);
                assert b.getUserName()!=null;
                assert b.getUserName().length()>4;
                users.add(i, b);
                users.get(i).setPrivilege(p);
            }
        }
    }
    public void remove(User b){
        users.remove(b);
    }

    public User authenticate(String userName,String password){
        for (int i = 0; i < getAllUsers().size(); i++) {
            if(getAllUsers().get(i).getUserName().equals(userName)&&getAllUsers().get(i).getPassword().equals(password)){
                return users.get(i);
            }
        }
        return null;
    }
}
