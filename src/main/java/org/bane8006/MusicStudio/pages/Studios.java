/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.util.Collection;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
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
    @Inject
    private IDataStudiosService dataStudios;

    @InjectPage
    private StudioDetails sdPage;
    @InjectPage
    private AddStudios addStudio;

    @Property
    private Studio studio;

    @Persist("flash")
    private String name;

    @ApplicationState
    @Property
    private User user;
    private boolean userExists;
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }
    @OnEvent(component="studioDetailsLink")
    Object onShowDetails(long id){
        Studio studio = dataStudios.getStudioById(id);
        sdPage.setId(studio.getIdStudio());
        return sdPage;
    }
    public Collection<Studio> getAllStudios(){
        return dataStudios.getAllStudios();
    }
    
    public boolean getAdmin(){
        if(user.getPrivilege().equals(Privilege.Owner))
            return true;
        else return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
