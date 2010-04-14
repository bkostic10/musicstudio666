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

/**
 *
 * @author Baxter
 */
public class Studios {
    
    private Serializable id;

    private User user;

    @Inject
    private IDataStudiosService dataStudios;

    @InjectPage
    private StudioDetails sdPage;

    @Property
    private Studio studio;
    @Persist
    private String name;
    @Persist
    private Privilege p;

    @OnEvent(component="studioDetailsLink")
    Object onShowDetails(String id){
        Studio studio = dataStudios.getStudioById(id);
        sdPage.setStudio(studio);
        return sdPage;
    }
    public Collection<Studio> getAllStudios(){
        return dataStudios.getAllStudios();
    }

    public Privilege getP() {
        return p;
    }

    public void setP(Privilege p) {
        this.p = p;
    }
    public boolean getAdmin(){
        if(p.equals(Privilege.Admin))
            return true;
        else return false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    void onActivate(Serializable id){
        System.out.println("Activated:"+id);
        this.id = getId();
    }
    Serializable onPassivate(){
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public long getId(){
        return User.class.cast(user).getId();
    }
    
}
