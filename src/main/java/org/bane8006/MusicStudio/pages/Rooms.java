/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.data.MockDataRooms;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class Rooms {
    @ApplicationState
    private String userWelcome;

    @ApplicationState
    private User user;
    private boolean userExists;

    @ApplicationState
    private MockDataRooms dataRooms;

    @InjectPage
    private RoomDetails rdPage;

    private RoomBean roomBean;
    
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }
    @OnEvent(component="roomDetailsLink")
    Object onShowDetails(String name){
        RoomBean roomBean = dataRooms.getRoomByName(name);
        rdPage.setRoom(roomBean);
        return rdPage;
    }

    public ArrayList<RoomBean> getAllRooms(){
        return dataRooms.getAllRooms();
    }
    public RoomBean getRoom(){
        return roomBean;
    }
    public void setRoom(RoomBean r){
        roomBean = r;
    }
    public String getUserWelcome() {
        return userWelcome;
    }

    public void setUserWelcome(String userWelcome) {
        this.userWelcome = userWelcome;
    }


}
