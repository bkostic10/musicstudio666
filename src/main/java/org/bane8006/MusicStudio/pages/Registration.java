/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.aints.User;

/**
 *
 * @author Baxter
 */
public class Registration {

    private String name;

    private String password2;

    @Inject
    private IDataUserService a;
    
    @Property
    @Persist("flash")
    private User user;
    
    @InjectPage
    private Registration registration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    void onActivate(String fullName){
        System.out.println("Activated:"+fullName);
        this.name = fullName;
    }
    String onPassivate(){
        return name;
    }
    @SetupRender
    public void createObject(){
        user = new UserBean();
    }

    Object onSubmitFromRegistrationForm(){
        System.out.println("Handling form submission!");
        if(user.getUserName().equals("admin")&&user.getPassword().equals("admin")){
            user.setPrivilege(Privilege.Admin);
        }else{
            user.setPrivilege(Privilege.User);
        }
        if(!user.getPassword().equals(password2)){
            registration.setName("Passwords doesn't match!!!");
        }
        else if (a.getAllUsers().contains(user)) {
            registration.setName("Username exists!!!");
        }
        else{
            a.addUser(user);
            registration.setName("Successful registration: "+user.getFirstName()+" "+user.getLastName());
        }
        return registration;
    }
    public long getId(){
        return User.class.cast(user).getId();
    }
}
