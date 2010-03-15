/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.data.MockDataUser;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class EditUser {
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String userName;
    private String oldPassword;
    private String password;
    private String password2;

    private String name;
    @ApplicationState
    private User user2;
    private boolean userExists;
    private User user;
    @InjectPage
    private EditUser edit;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("Setting first name: " + firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println("Setting last name: " + lastName);
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("Setting password: " + password);
        this.password = password;
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
        System.out.println("Setting password: " + password);
        this.oldPassword = oldPassword;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        System.out.println("Setting personal number: " + personalNumber);
        this.personalNumber = personalNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        System.out.println("Setting username: " + userName);
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName(){
        return getFirstName()+" "+getLastName();
    }

    void onActivate(String fullName){
        System.out.println("Activated:"+fullName);
        this.name = fullName;
    }
    String onPassivate(){
        return name;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }


    Object onSubmitFromEditUserForm(){
        System.out.println("Handling form submission!");
        IDataUser a = new MockDataUser();
        user = new UserBean();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPersonalNumber(personalNumber);
        user.setUserName(userName);
        user.setPassword(password);
        if(getOldPassword().equals(user2.getPassword())&&getPassword()!=null&&getPassword().equals(getPassword2())){
            a.replace((UserBean) user2,(UserBean) user);
            edit.setName("Info is changed");
            setUser2(null);
        }
        else{
            edit.setName("Data invalid!!!");
        }
        return edit;
    }
}
