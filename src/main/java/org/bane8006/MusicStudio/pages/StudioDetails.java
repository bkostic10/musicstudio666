/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
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
public class StudioDetails {

    private Serializable id;
    
    @Property
    private Studio studio;

    @InjectPage
    private Rooms r;

    @InjectPage
    private AddRooms ar;

    @InjectPage
    private Studios st;

    @Inject
    private IDataStudiosService ds;

    @ApplicationState
    @Property
    private User user;
    private boolean userExists;
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }
    @OnEvent(component="roomsLink")
    Object onEvent(long id){
        Studio studio = ds.getStudioById(id);
        r.setId(studio.getIdStudio());

        return r;
    }
    @OnEvent(component="addRoomsLink")
    Object onAdd(long id){
        Studio studio = ds.getStudioById(id);
        ar.setId(studio.getIdStudio());
        return ar;
    }
    @OnEvent(component="deleteStudioLink")
    Object onDeleteStudio(){
        st.setName(studio.getStudioName()+" has been successfuly deleted!");
        ds.deleteStudio(studio);
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
    
    public boolean getAdmin(){
        if(user.getPrivilege().equals(Privilege.Owner))
            return true;
        else return false;
    }

    void setId(Serializable id) {
        this.id = id;
    }
}
