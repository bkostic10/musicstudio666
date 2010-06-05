/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.beans.RoomType;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.IDataStudiosService;

/**
 *
 * @author Baxter
 */
public class AddRooms {

    @Component(id="addRoomForm")
    private Form form;

    private String roomID;
    private String roomName;
    private RoomType roomType = RoomType.Recording;
    private String description = "Studio has:\nGuitar Head:\nGuitar Speaker:\nBass head:\nBass Speaker:\nMixer:\nVoice Speaker:\nDrums:";

    @Persist("flash")
    private String name;
    
    private Serializable id;

    @Inject
    private IDataStudiosService dataStudios;

    private Room room;

    @Property
    private Studio studio;

    @InjectPage
    private AddRooms page;
    @Property
    @ApplicationState
    private User user;
    private boolean userExists;
    Object onActivate()
    {
        if(!userExists)return Index.class;
        else if(user.getPrivilege()==Privilege.User){
            return Studios.class;
        }
        return null;
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

    void onActivate(long id){
        System.out.println("Activated:"+id);
        this.id = id;
        studio = dataStudios.getStudioById(id);
    }
    Serializable onPassivate(){
        return id;
    }
    void onValidateFromAddRoomForm(){
        for(Room r:studio.getAllRooms()){
            if(r.getRoomID().equals(roomID))
                form.recordError("Room exists!!!");
        }

    }
    void onSuccessFromAddRoomForm(){
        System.out.println("Handling form submission!");
        room = new RoomBean();
        room.setRoomID(roomID);
        room.setRoomName(roomName);
        room.setRoomType(roomType);
        room.setDescription(description);

        studio.addRoom(room);
        dataStudios.updateStudio(studio);
        page.setName("Room "+getRoomName()+" is successfuly added!");
    }

    void setId(Serializable id) {
        this.id = id;
    }
}
