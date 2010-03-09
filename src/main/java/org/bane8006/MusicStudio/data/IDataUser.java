/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public interface IDataUser {
    public void oldUsers();
    public ArrayList<UserBean> getAllUsers();
    public UserBean getUserByUserName(String name);
    public void addUserBean(UserBean ub);
    public User authenticate(String userName,String password);
}
