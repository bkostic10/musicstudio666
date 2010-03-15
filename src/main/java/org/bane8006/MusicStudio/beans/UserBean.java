/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;

import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class UserBean implements User{
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String userName;
    private String password;
    private Privilege privilege;

    public UserBean() {
    }

    public UserBean(String firstName, String lastName,String personalNumber,String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.personalNumber = personalNumber;
    }
    
    public UserBean(String firstName, String lastName, String personalNumber, String userName,Privilege p) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.userName = userName;
        this.privilege = p;
    }
    public UserBean(String firstName, String lastName, String personalNumber, String userName, String password,Privilege p) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.userName = userName;
        this.password = password;
        this.privilege = p;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        assert firstName!=null;
        assert !firstName.equals(" ");
        assert !firstName.equals("");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        assert lastName!=null;
        assert !lastName.equals(" ");
        assert !lastName.equals("");
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        assert personalNumber!=null;
        assert !personalNumber.equals(" ");
        assert !personalNumber.equals("");
        this.personalNumber = personalNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        assert password!=null;
        assert !password.equals(" ");
        assert !password.equals("");
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        assert userName!=null;
        assert !userName.equals(" ");
        assert !userName.equals("");
        this.userName = userName;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        assert privilege!=null;
        this.privilege = privilege;
    }
    
    public boolean equals(Object o){
        UserBean u = (UserBean)(o);
        if(userName.equals(u.getUserName()))return true;
        else return false;
    }
}