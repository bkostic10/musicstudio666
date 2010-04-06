/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.beans.RoomType;
import org.bane8006.MusicStudio.aints.Room;
import org.bane8006.MusicStudio.aints.Studio;
import org.bane8006.MusicStudio.aints.User;

/**
 *
 * @author Baxter
 */
public class AddRooms {
    private String roomID;
    private String roomName;
    private RoomType roomType = RoomType.Recording;
    private String description = "Studio has:\nGuitar Head:\nGuitar Speaker:\nBass head:\nBass Speaker:\nMixer:\nVoice Speaker:\nDrums:";

    private String name;
    
    @ApplicationState
    private User user;
    private boolean userExists;
    
    private Room room;

    @Persist
    private Studio studio;

    @InjectPage
    private AddRooms page;

    Object onActivate()
    {
        if (!userExists) {
            return Index.class;
        }
        else if(user.getPrivilege().equals(Privilege.User)){
            return Studios.class;
        }
        else return null;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }



    void onActivate(String room){
        System.out.println("Activated:"+room);
        this.name = room;
    }
    String onPassivate(){
        return name;
    }

    Object onSubmitFromAddRoomForm(){
        System.out.println("Handling form submission!");
        room = new RoomBean();
        room.setRoomID(roomID);
        room.setRoomName(roomName);
        room.setRoomType(roomType);
        room.setDescription(description);


        if(!studio.getAllRooms().contains(room)){
            studio.addRoom(room);
            page.setName("Room "+getRoomName()+" is successfuly added!");
        }
        else{
            page.setName("Room exists!!!");
        }
        return page;
    }
}
