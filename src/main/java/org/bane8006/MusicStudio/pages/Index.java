package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.service.ILoggedUser;


/**
 * Start page of application Studio.
 */
public class Index
{
    @Component(id="loginForm")
    private Form form;

    private String userName;
    private String password;

    @InjectPage
    private Studios studios;

    @Inject
    private IDataUserService a;
    @Inject
    private ILoggedUser lu;
    @ApplicationState
    @Property
    private User user;
    private boolean userExists;
    @Persist("flash")
    private String message;
    
    Object onActivate()
    {
        if (userExists) return Studios.class;
        return null;
    }

    void onValidateFormFromLoginForm(){
        User aUser = null;
        aUser = a.authenticate(userName, password);
        if(aUser!=null){
            user = aUser;
            lu.addUser(user);
        }
        else{
            form.recordError("Username or password incorrect");
        }
    }
    Object onSuccessFromLoginForm(){
        return studios;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
