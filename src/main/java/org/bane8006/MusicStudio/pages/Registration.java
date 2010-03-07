/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.InjectPage;


/**
 *
 * @author Baxter
 */
public class Registration {
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String userName;
    private String password;
    private String password2;

    private String name;

    @InjectPage
    private Registration registration;

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
        this.name = fullName+" is successfuly registered!";
    }
    String onPassivate(){
        return name;
    }

    Object onSubmitFromRegistrationForm(){
        System.out.println("Handling form submission!");
        registration.setName(getFullName());
        return registration;
    }
}
