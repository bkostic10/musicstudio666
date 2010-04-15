/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
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
public class RoomDetails {

    @Persist
    private Room room;

    @Inject
    private IDataStudiosService dataStudios;

    @Inject
    private ILoggedUser lu;
    
    @Persist
    private Studio studio;

    @InjectPage
    private Rooms page;
    
    Object onActivate()
    {
        if (lu.getAllUsers().isEmpty()) return Index.class;
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
        page.setName(room.getRoomName()+" has been successfuly deleted!");
        studio.deleteRoom(room);
        return page;
    }
    public User getUser(){
        return lu.getFirst();
    }
    public boolean getAdmin(){
        if(getUser().getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }
}
