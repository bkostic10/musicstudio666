/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Persist;
import org.bane8006.MusicStudio.service.Room;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class RoomDetails {
    @ApplicationState
    private String userWelcome;

    @Persist
    private Room r;

    @ApplicationState
    private User user;
    private boolean userExists;
    
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

    public String getUserWelcome() {
        return userWelcome;
    }

    public void setUserWelcome(String userWelcome) {
        this.userWelcome = userWelcome;
    }

    
    
}
