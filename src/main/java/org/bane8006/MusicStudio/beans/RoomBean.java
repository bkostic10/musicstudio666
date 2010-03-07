/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;


import org.bane8006.MusicStudio.service.Room;
import org.bane8006.MusicStudio.service.Studio;

/**
 *
 * @author Baxter
 */
public class RoomBean implements Room{
    private String roomID;
    private String roomName;
    private Studio s;

    private boolean roomReserved;

   


    public RoomBean(String roomID, String roomName, boolean roomReserved) {

        this.roomID = roomID;
        this.roomName = roomName;
        this.roomReserved = roomReserved;
    }

    public Studio getS() {
        return s;
    }

    public void setS(Studio s) {
        this.s = s;
    }
    

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isRoomReserved() {
        return roomReserved;
    }

    public void setRoomReserved(boolean roomReserved) {
        this.roomReserved = roomReserved;
    }

}
