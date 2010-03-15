/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class UserInfo {
    @ApplicationState
    private User user;
    private boolean userExists;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }
}
