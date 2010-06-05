package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.ILoggedUser;

public class LogOut
{
    @Inject
    private ILoggedUser lu;
    @ApplicationState
    private User user;
    private boolean userExists;
    public void setUser(User user) {
        this.user = user;
    }

    Object onActivate()
    {
        if(userExists){
            lu.remove(user);
            setUser(null);
            return Index.class;
        }
 	return Index.class;
    }
}
