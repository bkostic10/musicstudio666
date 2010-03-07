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

    public UserBean() {
    }

    public UserBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    

    public UserBean(String firstName, String lastName, String personalNumber, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.userName = userName;
        this.password = password;
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

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
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