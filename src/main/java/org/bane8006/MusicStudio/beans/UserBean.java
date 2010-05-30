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
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */


@Entity
public class UserBean implements User, Serializable{
    

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

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        assert firstName!=null;
        assert !firstName.equals(" ");
        assert !firstName.equals("");
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        assert lastName!=null;
        assert !lastName.equals(" ");
        assert !lastName.equals("");
        this.lastName = lastName;
    }

    @Override
    public String getPersonalNumber() {
        return personalNumber;
    }

    @Override
    public void setPersonalNumber(String personalNumber) {
        assert personalNumber!=null;
        assert !personalNumber.equals(" ");
        assert !personalNumber.equals("");
        this.personalNumber = personalNumber;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        assert password!=null;
        assert !password.equals(" ");
        assert !password.equals("");
        this.password = password;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        assert userName!=null;
        assert !userName.equals(" ");
        assert !userName.equals("");
        this.userName = userName;
    }

    @Override
    public Privilege getPrivilege() {
        return privilege;
    }

    @Override
    public void setPrivilege(Privilege privilege) {
        assert privilege!=null;
        this.privilege = privilege;
    }
    
    @Override
    public boolean equals(Object o){
        User u = (UserBean)(o);
        if(userName.equals(u.getUserName()))return true;
        else return false;
    }

    @Override
    public long getIdUser() {
        return id;
    }
}