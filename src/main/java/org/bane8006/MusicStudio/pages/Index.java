package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.service.User;
import org.bane8006.MusicStudio.data.IDataUser;


/**
 * Start page of application Studio.
 */
public class Index
{
    private String userName;
    private String password;

    @InjectPage
    private Studios studios;
    
    @Inject
    private IDataUser a;

    @ApplicationState
    private User user;

    Object onSubmitFromLoginForm(){
        Class nextPage = null;
        User aUser = null;
        aUser = a.authenticate(userName, password);
        if(aUser!=null){
            user = aUser;
            nextPage = Studios.class;
        }
        return nextPage;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
