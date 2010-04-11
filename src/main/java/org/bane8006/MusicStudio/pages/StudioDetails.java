/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;



import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public class StudioDetails {

    
    
    @Persist
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
    @Property
    @ApplicationState
    private User user;
    private boolean userExists;

    private String name;
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }
    @OnEvent(component="roomsLink")
    Object onEvent(String id){
        Studio studio = ds.getStudioById(id);
        r.setStudio(studio);
        return r;
    }
    @OnEvent(component="addRoomsLink")
    Object onAdd(String id){
        Studio studio = ds.getStudioById(id);
        ar.setStudio(studio);
        return ar;
    }
    @OnEvent(component="deleteStudioLink")
    Object onDeleteStudio(){
        ds.deleteStudio(studio);
        return st;
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
    
    
    public boolean getAdmin(){
        if(user.getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }
}
