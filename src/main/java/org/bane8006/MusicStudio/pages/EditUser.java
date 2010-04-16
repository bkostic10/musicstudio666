/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.ILoggedUser;

/**
 *
 * @author Baxter
 */
public class EditUser {
    
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String userName;
    private String password;
    private String oldPassword;
    private String password2;
    @Persist("flash")
    private String name;
    private Serializable id;

    @Inject
    private ILoggedUser lu;

    @Inject
    private IDataUserService a;

    @Property
    private User user;

    @InjectPage
    private EditUser edit;

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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        System.out.println("Setting password: " + oldPassword);
        this.oldPassword = oldPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void onActivate(Serializable id){
        System.out.println("Activated:"+id);
        this.id = getIdUser();
    }
    Serializable onPassivate(){
        return id;
    }
    public User getUser2() {
        return lu.getFirst();
    }

    Object onSubmitFromEditUserForm(){
        System.out.println("Handling form submission!");
        user = new UserBean();
        user.setPrivilege(getUser2().getPrivilege());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserName(userName);
        user.setPassword(password);
        if(getOldPassword().equals(getUser2().getPassword())&&user.getPassword().equals(getPassword2())){
            a.replace(getUser2().getIdUser(), user);
            edit.setName("Info is changed");
            lu.remove();
        }
        else{
            edit.setName("Data invalid!!!");
        }
        return edit;
    }
    public long getIdUser(){
        return User.class.cast(user).getIdUser();
    }
}
