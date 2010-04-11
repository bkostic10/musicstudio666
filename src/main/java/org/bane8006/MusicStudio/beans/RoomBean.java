/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;


import org.bane8006.MusicStudio.Room;

/**
 *
 * @author Baxter
 */
public class RoomBean implements Room{
    private String roomID;
    private String roomName;
    private RoomType roomType;
    private String description;

    public RoomBean() {
    }

    public RoomBean(String roomID, String roomName, RoomType roomType, String description) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.description = description;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        assert roomID!=null;
        assert !roomID.equals(" ");
        assert !roomID.equals("");
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        assert roomName!=null;
        assert !roomName.equals(" ");
        assert !roomName.equals("");
        this.roomName = roomName;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        assert roomType!=null;
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        assert description!=null;
        assert !description.equals("");
        assert !description.equals(" ");
        this.description = description;
    }


    public boolean equals(Object o){
        Room r = (RoomBean)(o);
        if(roomID.equals(r.getRoomID())){return true;}
            else return false;
    }

}
