/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;

import java.util.ArrayList;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.data.MockDataUser;
import org.bane8006.MusicStudio.service.Authentication;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class AuthenticationBean implements Authentication{

    private IDataUser user = new MockDataUser();


    public ArrayList<UserBean> getUsers(){
        return user.getAllUsers();
    }

//    private static final String USERNAME = "user";
//    private static final String PASSWORD = "secret";
//    public static UserBean authenticate(String userName,String password){
//        if(USERNAME.equals(userName)&&PASSWORD.equals(password)){
//            return new UserBean();
//        }
//        return null;
//    }
    public User authenticate(String userName,String password){
        for (int i = 0; i < getUsers().size(); i++) {
            if(getUsers().get(i).getUserName().equals(userName)&&getUsers().get(i).getPassword().equals(password)){
                String firstName = getUsers().get(i).getFirstName();
                String lastName = getUsers().get(i).getLastName();
                return new UserBean(firstName,lastName);
            }
        }

        return null;
    }
}
