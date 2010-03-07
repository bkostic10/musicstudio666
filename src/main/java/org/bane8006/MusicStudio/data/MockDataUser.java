/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.beans.UserBean;

/**
 *
 * @author Baxter
 */
public class MockDataUser implements IDataUser{

    private List<UserBean> users = new ArrayList<UserBean>();

    public MockDataUser() {
        addUserBean(new UserBean("Pera", "Pampur", "0706987483921", "pera111", "pera111"));
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

    public void addUserBean(UserBean ub) {
        users.add(ub);
    }

}
