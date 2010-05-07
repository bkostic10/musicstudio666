/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.ILoggedUser;

/**
 *
 * @author Baxter
 */
public class UserInfo {

    @Inject
    private ILoggedUser lu;


    public User getUser() {
        return lu.getFirst();
    }
    
    Object onActivate()
    {
        if (lu.getAllUsers().isEmpty()) return Index.class;
        return null;
    }
}
