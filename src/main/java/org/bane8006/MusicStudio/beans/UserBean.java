/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */


@Entity
public class UserBean implements User,Serializable{
    

    public UserBean(String firstName, String lastName, String password, String personalNumber, Privilege privilege, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.userName = userName;
        this.password = password;
        this.privilege = privilege;
    }

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String firstName;
    @Basic
    private String lastName;
    @Basic
    private String personalNumber;
    @Column(name = "userName",nullable=false,unique=true)
    private String userName;
    @Basic
    private String password;
    @Basic
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
        User u = (UserBean)(o);
        if(userName.equals(u.getUserName()))return true;
        else return false;
    }

    public long getId() {
        return id;
    }
}