/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;



import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.bane8006.MusicStudio.service.Studio;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class StudioDetails {
    @ApplicationState
    private String userWelcome;

    @Persist
    private Studio s;

    @InjectPage
    private Rooms r;

    @ApplicationState
    private User user;
    private boolean userExists;

    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }

    public void setStudio(Studio s)
    {
        this.s = s;
    }
    public Studio getStudio()
    {
        return s;
    }

    public String getUserWelcome() {
        return userWelcome;
    }

    public void setUserWelcome(String userWelcome) {
        this.userWelcome = userWelcome;
    }
}
