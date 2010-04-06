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
import org.bane8006.MusicStudio.aints.Room;
import org.bane8006.MusicStudio.aints.Studio;
import org.bane8006.MusicStudio.aints.User;

/**
 *
 * @author Baxter
 */
public class RoomDetails {

    @Persist
    private Room room;
    @Property
    @ApplicationState
    private User user;
    private boolean userExists;

    @Inject
    private IDataStudiosService dataStudios;

    @Persist
    private Studio studio;

    @InjectPage
    private Studios page;
    
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
    @OnEvent(component="deleteRoomLink")
    Object onDeleteRoom(String id){
        Room room = studio.getRoomById(id);
        studio.deleteRoom(room);
        return page;
    }
        public boolean getAdmin(){
        if(user.getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }
}
