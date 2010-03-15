/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;


import org.bane8006.MusicStudio.service.Room;

/**
 *
 * @author Baxter
 */
public class RoomBean implements Room{
    private String roomID;
    private String roomName;
    private String studioID;
    private RoomType roomType;

    public RoomBean() {
    }

    public RoomBean(String roomID, String roomName, String studioID, RoomType roomType) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.studioID = studioID;
        this.roomType = roomType;
    }

    
    public RoomBean(String roomID, String roomName,String studioID) {

        this.roomID = roomID;
        this.roomName = roomName;
        this.studioID = studioID;
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

    public String getStudioID() {
        return studioID;
    }

    public void setStudioID(String studioID) {
        assert studioID!=null;
        assert !studioID.equals(" ");
        assert !studioID.equals("");
        this.studioID = studioID;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        assert roomType!=null;
        this.roomType = roomType;
    }

    public boolean equals(Object o){
        RoomBean r = (RoomBean)(o);
        if(roomID.equals(r.getRoomID())&&studioID.equals(r.getStudioID())){return true;}
            else return false;
    }

}
