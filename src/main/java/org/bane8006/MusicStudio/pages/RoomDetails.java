/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.data.IDataRooms;
import org.bane8006.MusicStudio.data.MockDataRooms;
import org.bane8006.MusicStudio.service.Room;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class RoomDetails {

    @Persist
    private Room r;

    @ApplicationState
    private User user;
    private boolean userExists;

    @InjectPage
    private Studios page;
    
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }

    public Room getRoom() {
        return r;
    }

    public void setRoom(Room r) {
        this.r = r;
    }

    public User getUser() {
        return user;
    }
    @OnEvent(component="deleteRoomLink")
    Object onDeleteRoom(){
        IDataRooms ar = new MockDataRooms();
        ar.deleteRoom((RoomBean) r);
        return page;
    }
        public boolean getAdmin(){
        if(user.getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }
}
