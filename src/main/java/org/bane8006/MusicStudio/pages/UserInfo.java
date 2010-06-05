/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Property;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public class UserInfo {


    @ApplicationState
    @Property
    private User user;
    private boolean userExists;
    
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }
}
