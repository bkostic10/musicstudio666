/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.bane8006.MusicStudio.Room;

@Entity
public class RoomBean implements Room{
    @Id
    @GeneratedValue
    private long id;
    @Basic
    private String roomID;
    @Basic
    private String roomName;
    @Basic
    private RoomType roomType;
    @Basic
    private String description;

    @Override
    public long getIdRoom() {
        return id;
    }

    public RoomBean() {
    }

    public RoomBean(String roomID, String roomName, RoomType roomType, String description) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.description = description;
    }

    @Override
    public String getRoomID() {
        return roomID;
    }

    @Override
    public void setRoomID(String roomID) {
        assert roomID!=null;
        assert !roomID.equals(" ");
        assert !roomID.equals("");
        this.roomID = roomID;
    }

    @Override
    public String getRoomName() {
        return roomName;
    }

    @Override
    public void setRoomName(String roomName) {
        assert roomName!=null;
        assert !roomName.equals(" ");
        assert !roomName.equals("");
        this.roomName = roomName;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public void setRoomType(RoomType roomType) {
        assert roomType!=null;
        this.roomType = roomType;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        assert description!=null;
        assert !description.equals("");
        assert !description.equals(" ");
        this.description = description;
    }


    @Override
    public boolean equals(Object o){
        Room r = (RoomBean)(o);
        if(roomID.equals(r.getRoomID())){return true;}
            else return false;
    }

}
