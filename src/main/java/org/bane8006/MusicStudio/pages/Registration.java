/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class Registration {

    private String name;

    @Inject
    private IDataUser a;
    
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
        user.setPrivilege(Privilege.User);}
        if (!a.getAllUsers().contains(user)) {
            a.addUser(user);
            registration.setName("Successful registration: "+user.getFirstName()+" "+user.getLastName());
        }
        else{
            registration.setName("User exists");
        }
        return registration;
    }
}
