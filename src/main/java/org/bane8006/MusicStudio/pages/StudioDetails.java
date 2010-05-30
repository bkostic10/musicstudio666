/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.ILoggedUser;

/**
 *
 * @author Baxter
 */
public class StudioDetails {

    private Serializable id;
    //@Persist
    private Studio studio;

    private Room room;
    
    @InjectPage
    private Rooms r;

    @InjectPage
    private AddRooms ar;

    @InjectPage
    private Studios st;

    @Inject
    private IDataStudiosService ds;


    @Inject
    private ILoggedUser lu;

    Object onActivate()
    {
        if (lu.getAllUsers().isEmpty()) return Index.class;
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
        setStudio(ds.getStudioById(id));
        ds.lockStudio(studio);
    }
    Serializable onPassivate(){
        return id;
    }
    public void setStudio(Studio studio)
    {
        this.studio = studio;
    }
    public Studio getStudio()
    {
        return studio;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser(){
        return lu.getFirst();
    }
    public boolean getAdmin(){
        if(getUser().getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }

//    public long getId(){
//        return Studio.class.cast(studio).getIdStudio();
//    }

    void setId(Serializable id) {
        this.id = id;
    }
}
