package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.service.ILoggedUser;


/**
 * Start page of application Studio.
 */
public class Index
{
    private String userName;
    private String password;
    private String message;
    @InjectPage
    private Studios studios;
    @InjectPage
    private Index index;
    
    @Inject
    private IDataUserService a;
    @Inject
    private ILoggedUser lu;
    private User user;

    Object onActivate()
    {
        if (lu.getAllUsers().isEmpty()) return null;
        return Studios.class;
    }
    Object onSubmitFromLoginForm(){
        User aUser = null;
        aUser = a.authenticate(userName, password);
        if(aUser!=null){
            user = aUser;
            lu.addUser(user);
            return studios;
        }
        else{
            System.out.println("Username or password incorrect");
            index.setMessage("Username or password incorrect");
        }
        return index;
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
    void onActivate(String message){
        this.message = message;
    }
    String onPassivate(){
        return message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
