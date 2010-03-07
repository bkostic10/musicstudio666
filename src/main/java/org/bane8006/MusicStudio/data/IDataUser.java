/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import org.bane8006.MusicStudio.beans.UserBean;

/**
 *
 * @author Baxter
 */
public interface IDataUser {
    public ArrayList<UserBean> getAllUsers();
    public UserBean getUserByUserName(String name);
    public void addUserBean(UserBean ub);
}
