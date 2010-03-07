package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.bane8006.MusicStudio.service.User;

public class LogOut
{
    @ApplicationState
    private User user;
    private boolean userExists;

    public void setUser(User user) {
        this.user = user;
    }

    @ApplicationState
    private String userWelcome;

    public void setUserWelcome(String userWelcome) {
        this.userWelcome = userWelcome;
    }


    Object onActivate()
    {
        setUser(null);
        setUserWelcome(null);
        if (!userExists) return Index.class;
        return null;
    }
}
