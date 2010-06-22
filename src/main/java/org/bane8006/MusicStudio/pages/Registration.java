/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public class Registration {
    @Component(id="registrationForm")
    private Form form;
    private Serializable id;
    @Persist("flash")
    private String name;
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String userName;
    private String password;
    private String password2;

    @Inject
    private IDataUserService a;
    
    @Property
    private User user;
    
    @InjectPage
    private Registration registration;
    
    @ApplicationState
    private User user2;
    private boolean user2Exists;
    Object onActivate()
    {
        if (!user2Exists) return null;
        return Studios.class;
    }
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    void onActivate(Serializable id){
        System.out.println("Activated:"+id);
        this.id = getId();
    }
    Serializable onPassivate(){
        return id;
    }

    void onValidateFormFromRegistrationForm(){
        if(!password.equals(password2)){
            form.recordError("Passwords don't match!!!");
        }
        for(User u:a.getAllUsers()){
            if(u.getUserName().equals(userName))
                form.recordError("Username exists!!!");
        }

    }
    void onSuccessFromRegistrationForm(){
        System.out.println("Handling form submission!");
        user = new UserBean();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPersonalNumber(personalNumber);
        user.setUserName(userName);
        user.setPassword(password);

        if(user.getUserName().equals("admin")&&user.getPassword().equals("admin")){
            user.setPrivilege(Privilege.Owner);
        }
        else{
            user.setPrivilege(Privilege.User);
        }
        a.addUser(user);
        registration.setName("Successful registration: " + user.getFirstName() + " " + user.getLastName());
        
    }
    public long getId(){
        return User.class.cast(user).getIdUser();
    }
}
