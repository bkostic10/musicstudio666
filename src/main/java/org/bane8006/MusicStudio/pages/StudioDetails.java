/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
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
public class StudioDetails {
    @Persist
    private boolean userExists;
    @Persist
    private long idUser;

    private Serializable id;
    
    @Property
    private Studio studio;
    @Property
    private User user;

    @InjectPage
    private Rooms r;

    @InjectPage
    private AddRooms ar;

    @InjectPage
    private Studios st;

    @Inject
    private IDataStudiosService ds;
    @Inject
    private IDataUserService du;

    @Inject
    private ILoggedUser lu;

    Object onActivate()
    {
        if (userExists==false) return Index.class;
        return null;
    }
    @OnEvent(component="roomsLink")
    Object onEvent(long id){
        Studio studio = ds.getStudioById(id);
        r.setId(studio.getIdStudio());
        r.setIdUser(idUser);
        r.setUserExists(userExists);
        return r;
    }
    @OnEvent(component="addRoomsLink")
    Object onAdd(long id){
        Studio studio = ds.getStudioById(id);
        ar.setId(studio.getIdStudio());
        ar.setIdUser(idUser);
        ar.setUserExists(userExists);
        return ar;
    }
    @OnEvent(component="deleteStudioLink")
    Object onDeleteStudio(){
        st.setName(studio.getStudioName()+" has been successfuly deleted!");
        ds.deleteStudio(studio);
        st.setIdUser(idUser);
        st.setUserExists(userExists);
        return st;
    }
    void onActivate(long id){
        System.out.println("Activated:"+id);
        this.id = id;
        studio = ds.getStudioById(id);
    }
    Serializable onPassivate(){
        return id;
    }
    
//    public User getUser(){
//        return lu.getFirst();
//    }
    public boolean getAdmin(){
        if(user.getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }

//    public long getId(){
//        return Studio.class.cast(studio).getIdStudio();
//    }

    void setId(Serializable id) {
        this.id = id;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    public long getIdUser() {
        return idUser;
    }
    
    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }
    @BeginRender
    public void pageActivation(){
        user = du.getUserByUserName(idUser);
    }
}
