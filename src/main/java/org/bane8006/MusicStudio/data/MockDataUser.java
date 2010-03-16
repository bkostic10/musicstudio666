/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class MockDataUser implements IDataUser{

    private static List<UserBean> users = new ArrayList<UserBean>();

    public MockDataUser() {
        addUserBean(new UserBean("Pera", "Pampur", "0706987483921", "admin", "admin",Privilege.Admin));
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
    public void replace(UserBean b2,UserBean b){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(b2.getUserName())){
                Privilege p = users.get(i).getPrivilege();
                users.remove(i);
                users.add(i, b);
                users.get(i).setPrivilege(p);
            }
        }
    }
    public void remove(UserBean b){
        users.remove(b);
    }

    public User authenticate(String userName,String password){
        for (int i = 0; i < getAllUsers().size(); i++) {
            if(getAllUsers().get(i).getUserName().equals(userName)&&getAllUsers().get(i).getPassword().equals(password)){
                String firstName = getAllUsers().get(i).getFirstName();
                String lastName = getAllUsers().get(i).getLastName();
                String personalNumber = getAllUsers().get(i).getPersonalNumber();
                Privilege p = getAllUsers().get(i).getPrivilege();
                return new UserBean(firstName,lastName,personalNumber,userName,password,p);
            }
        }
        return null;
    }
}
