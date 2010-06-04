/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.util.Collection;
import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.service.ILoggedUser;

/**
 *
 * @author Baxter
 */
public class Studios {
    @Persist
    private boolean userExists;
    @Persist
    private long idUser;
    @Inject
    private IDataStudiosService dataStudios;

    @InjectPage
    private StudioDetails sdPage;
    @InjectPage
    private AddStudios addStudio;

    @Property
    private Studio studio;

    @Property
    private User user;

    @Persist("flash")
    private String name;

    @Inject
    private IDataUserService du;

    @Inject
    private ILoggedUser lu;

    Object onActivate()
    {
        if (userExists==false) {
            return Index.class;
        }
        return null;
    }
    @OnEvent(component="studioDetailsLink")
    Object onShowDetails(long id){
        Studio studio = dataStudios.getStudioById(id);
        sdPage.setId(studio.getIdStudio());
        sdPage.setIdUser(idUser);
        sdPage.setUserExists(userExists);
        return sdPage;
    }
//    @OnEvent(component="addStudioLink")
//    Object onAddStudio(){
//        addStudio.setIdUser(idUser);
//        addStudio.setUserExists(userExists);
//        return addStudio;
//    }
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

//    public User getUser() {
//        return lu.getFirst();
//    }

    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }

    public boolean isUserExists() {
        return userExists;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdUser() {
        return idUser;
    }
    
    @BeginRender
    public void pageActivation(){
        user = du.getUserByUserName(idUser);
    }
}
