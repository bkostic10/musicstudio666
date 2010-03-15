/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.beans.RoomType;
import org.bane8006.MusicStudio.data.IDataRooms;
import org.bane8006.MusicStudio.data.MockDataRooms;
import org.bane8006.MusicStudio.service.Room;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class AddRooms {
    private String roomID;
    private String roomName;
    private String studioID;
    private RoomType roomType = RoomType.Recording;

    private String name;
    @ApplicationState
    private User user;
    private boolean userExists;
    @ApplicationState
    private Room room;

    @InjectPage
    private AddRooms page;

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

    public String getStudioID() {
        return studioID;
    }

    public void setStudioID(String studioID) {
        this.studioID = studioID;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    public RoomType getRecording(){
        return RoomType.Recording;
    }
        public RoomType getJamming(){
        return RoomType.Jamming;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    void onActivate(String room){
        System.out.println("Activated:"+room);
        this.name = room;
    }
    String onPassivate(){
        return name;
    }

    Object onSubmitFromAddStudioForm(){
        System.out.println("Handling form submission!");
        IDataRooms a = new MockDataRooms();
        room = new RoomBean();
        room.setRoomID(roomID);
        room.setRoomName(roomName);
        room.setStudioID(studioID);
        room.setRoomType(roomType);

        if(!a.getAllRooms().contains((RoomBean)room)){
            a.addRoomBean((RoomBean) room);
            page.setName("Room "+getRoomName()+" is successfuly added!");
        }
        else{
            page.setName("Room exists!!!");
        }
        return page;
    }
}
