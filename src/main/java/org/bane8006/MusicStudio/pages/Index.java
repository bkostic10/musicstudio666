package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.bane8006.MusicStudio.service.User;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.data.MockDataUser;


/**
 * Start page of application Studio.
 */
public class Index
{
    private String userName;
    private String password;
    @InjectPage
    private Studios studios;
    @ApplicationState
    private User user;

    Object onSubmitFromLoginForm(){
        Class nextPage = null;
        User aUser = null;
        IDataUser a = new MockDataUser();
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
