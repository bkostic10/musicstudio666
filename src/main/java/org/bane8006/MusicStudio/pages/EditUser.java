/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
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
public class EditUser {

    private String oldPassword;
    private String password2;
    private String name;
    
    @ApplicationState
    private User user2;
    private boolean userExists;

    @Inject
    private IDataUser a;
    @Property
    @Persist("flash")
    private User user;

    @InjectPage
    private EditUser edit;

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
    @SetupRender
    public void createObject(){
        user = new UserBean();
    }

    Object onSubmitFromEditUserForm(){
        System.out.println("Handling form submission!");
        user.setPrivilege(user2.getPrivilege());
        if(getOldPassword().equals(user2.getPassword())&&user.getPassword()!=null&&user.getPassword().equals(getPassword2())){
            a.replace(user2.getId(), user);
            edit.setName("Info is changed");
            setUser2(null);
        }
        else{
            edit.setName("Data invalid!!!");
        }
        return edit;
    }
}
