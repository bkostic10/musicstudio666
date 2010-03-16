/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.data.MockDataUser;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class DeleteAccount {
    @ApplicationState
    private User user;
    private boolean userExists;

    @InjectPage
    private DeleteAccount page;

    private String name;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName(){
        return user.getFirstName()+" "+user.getLastName();
    }

    void onActivate(String fullName){
        System.out.println("Activated:"+fullName);
        this.name = fullName;
    }
    String onPassivate(){
        return name;
    }
    Object onSubmitFromDeleteAccountForm(){
        System.out.println("Handling form submission!");
        IDataUser a = new MockDataUser();
        a.remove((UserBean) user);
        page.setName(getFullName()+" is successfuly deleted!");
        setUser(null);
        return page;
    }
}
