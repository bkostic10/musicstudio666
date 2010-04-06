/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.aints.User;

/**
 *
 * @author Baxter
 */
public class DeleteAccount {
    @ApplicationState
    private User user;
    private boolean userExists;

    @Inject
    private IDataUserService a;

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
        a.remove(getUser());
        page.setName(getFullName()+" is successfuly deleted!");
        setUser(null);
        return page;
    }
}
