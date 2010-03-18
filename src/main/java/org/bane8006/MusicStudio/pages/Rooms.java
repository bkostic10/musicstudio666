/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.data.IDataRooms;
import org.bane8006.MusicStudio.data.MockDataRooms;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class Rooms {


    @ApplicationState
    private User user;
    private boolean userExists;

    @Inject
    private IDataRooms dataRooms;

    @InjectPage
    private RoomDetails rdPage;

    private RoomBean roomBean;
    
    Object onActivate()
    {
        if (!userExists){
            return Index.class;
        }
        else return null;
    }
    @OnEvent(component="roomDetailsLink")
    Object onShowDetails(String id){
        RoomBean roomBean = dataRooms.getRoomById(id);
        rdPage.setRoom(roomBean);
        return rdPage;
    }

    public ArrayList<RoomBean> getAllRooms(){
        return dataRooms.getCertainRooms();
    }
    public RoomBean getRoom(){
        return roomBean;
    }
    public void setRoom(RoomBean r){
        roomBean = r;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
