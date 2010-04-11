/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.util.Collection;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public class Studios {
    @Property
    @ApplicationState
    private User user;
    private boolean userExists;

    @Inject
    private IDataStudiosService dataStudios;

    @InjectPage
    private StudioDetails sdPage;

    @Property
    private Studio studio;

    private String name;

    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }

    @OnEvent(component="studioDetailsLink")
    Object onShowDetails(String id){
        Studio studio = dataStudios.getStudioById(id);
        sdPage.setStudio(studio);
        return sdPage;
    }
    public Collection<Studio> getAllStudios(){
        return dataStudios.getAllStudios();
    }

    public boolean getAdmin(){
        if(user.getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    void onActivate(String n){
        System.out.println("Activated:"+n);
        this.name = n;
    }
    String onPassivate(){
        return name;
    }
    
}
