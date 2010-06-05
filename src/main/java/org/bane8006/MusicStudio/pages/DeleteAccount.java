/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;


import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.bane8006.MusicStudio.service.ILoggedUser;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public class DeleteAccount {

    @Inject
    private ILoggedUser lu;
    @Inject
    private IDataUserService a;

    @InjectPage
    private Index index;

    @ApplicationState
    @Property
    private User user2;
    private boolean user2Exists;
    Object onActivate()
    {
        if (!user2Exists) return Index.class;
        return null;
    }

    public String getFullName(){
        return user2.getFirstName()+" "+user2.getLastName();
    }

    Object onSubmitFromDeleteAccountForm(){
        System.out.println("Handling form submission!");
        a.remove(user2);
        index.setMessage(getFullName()+" is successfuly deleted!");
        lu.remove(user2);
        user2 = null;
        return index;
    }
}
