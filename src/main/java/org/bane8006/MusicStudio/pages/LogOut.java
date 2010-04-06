package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.bane8006.MusicStudio.aints.User;

public class LogOut
{
    @ApplicationState
    private User user;
    private boolean userExists;

    public void setUser(User user) {
        this.user = user;
    }
    Object onActivate()
    {
        setUser(null);
        if (!userExists) return Index.class;
        return null;
    }
}
