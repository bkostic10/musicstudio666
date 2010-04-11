/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;

/**
 *
 * @author Baxter
 */
public class Rooms {


    @Persist
    private Studio studio;
    @Property
    @ApplicationState
    private User user;
    private boolean userExists;

    @Inject
    private IDataStudiosService dataStudios;

    @InjectPage
    private RoomDetails rdPage;
    
    private Room room;
    
    Object onActivate()
    {
        if (!userExists){
            return Index.class;
        }
        else return null;
    }
    @OnEvent(component="roomDetailsLink")
    Object onShowDetails(String id){
        Room room = studio.getRoomById(id);
        rdPage.setRoom(room);
        rdPage.setStudio(studio);
        return rdPage;
    }

    public Room getRoom(){
        return room;
    }
    public void setRoom(Room r){
        room = r;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
    
}
