/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
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
    
    @Component(id="editUserForm")
    private Form form;

    private String firstName;
    private String lastName;
    private String personalNumber;
    private String userName;
    private String password;
    private String oldPassword;
    private String password2;

    @Inject
    private ILoggedUser lu;

    @Inject
    private IDataUserService a;

    @InjectPage
    private Index index;

    @ApplicationState
    @Property
    private User user2;
    private boolean user2Exists;
    Object onActivate()
    {
        if (!user2Exists) return Index.class;
        return null;
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
    
//    void onValidateFromEditUserForm(){
//        if(!getOldPassword().equals(user2.getPassword())){
//            form.recordError("Old password invalid!!!");
//        }
//        if(!getPassword().equals(getPassword2())){
//            form.recordError("Passwords don't match!!!");
//        }
//    }
    Object onSuccessFromEditUserForm(){
        System.out.println("Handling form submission!");
        User user = new UserBean();
        user.setPrivilege(user2.getPrivilege());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPersonalNumber(personalNumber);
        user.setUserName(userName);
        user.setPassword(password);
        if(!getOldPassword().equals(user2.getPassword())){
            form.recordError("Old password invalid!!!");
        }
        else if(!getPassword().equals(getPassword2())){
            form.recordError("Passwords don't match!!!");
        }
        else{
            a.replace(user2.getIdUser(), user);
            index.setMessage("Info is changed! Please login");
            lu.remove(user);
            user2 = null;
            return index;
        }
        return null;
    }
    public long getIdUser(){
        return User.class.cast(user2).getIdUser();
    }
}
