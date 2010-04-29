/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import java.util.Collection;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.ILoggedUser;

/**
 *
 * @author Baxter
 */
public class Studios {

    @Inject
    private IDataStudiosService dataStudios;

    @InjectPage
    private StudioDetails sdPage;

    @Property
    private Studio studio;
    @Persist("flash")
    private String name;

    @Inject
    private ILoggedUser lu;

    Object onActivate()
    {
        if (lu.getAllUsers().isEmpty()) return Index.class;
        return null;
    }
    @OnEvent(component="studioDetailsLink")
    Object onShowDetails(long id){
        Studio studio = dataStudios.getStudioById(id);
        if(studio!=null){
            sdPage.setStudio(studio);
        }
        return sdPage;
    }
    public Collection<Studio> getAllStudios(){
        return dataStudios.getAllStudios();
    }

    public boolean getAdmin(){
        if(getUser().getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return lu.getFirst();
    }
    
}
