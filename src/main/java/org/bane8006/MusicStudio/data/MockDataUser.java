/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class MockDataUser implements IDataUser{

    private static List<UserBean> users = new ArrayList<UserBean>();

    public void oldUsers() {
        User u1 = new UserBean();
        u1.setFirstName("Pera");
        u1.setLastName("Pampur");
        u1.setPersonalNumber("0706987483921");
        u1.setUserName("pera111");
        u1.setPassword("pera111");    
        addUserBean((UserBean) u1);
    }

    public ArrayList<UserBean> getAllUsers() {
        return (ArrayList<UserBean>) users;
    }

    public UserBean getUserByUserName(String name) {
         for(UserBean ub:users){
            if(ub.getUserName().equals(name))
                return ub;
        }
        return null;
    }
    public void addUserBean(UserBean ub){
        if(!users.contains(ub)){
            users.add(ub);
        }
        else System.out.println("User exists!");
    }

    public User authenticate(String userName,String password){
        oldUsers();
        for (int i = 0; i < getAllUsers().size(); i++) {
            if(getAllUsers().get(i).getUserName().equals(userName)&&getAllUsers().get(i).getPassword().equals(password)){
                String firstName = getAllUsers().get(i).getFirstName();
                String lastName = getAllUsers().get(i).getLastName();
                return new UserBean(firstName,lastName);
            }
        }
        return null;
    }
}
