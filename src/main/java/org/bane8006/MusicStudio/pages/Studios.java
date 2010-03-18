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
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.RoomType;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.data.IDataRooms;
import org.bane8006.MusicStudio.data.IDataStudios;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class Studios {

    @ApplicationState
    private User user;
    private boolean userExists;

    @Inject
    private IDataStudios dataStudios;

    @Inject
    private IDataRooms ar;

    @InjectPage
    private StudioDetails sdPage;

    private StudioBean studioBean;


    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }

    @OnEvent(component="studioDetailsLink")
    Object onShowDetails(String name){
        StudioBean studioBean = dataStudios.getStudioByName(name);
        ar.getCertainRooms().clear();
        int a = 0;
        int b = 0;
        for (int i = 0; i < ar.getAllRooms().size(); i++) {
            if(studioBean.getStudioID().equals(ar.getAllRooms().get(i).getStudioID())){
                ar.addCertainRoomBean(ar.getAllRooms().get(i));
                if(ar.getAllRooms().get(i).getRoomType().equals(RoomType.Jamming))
                a++;
                else b++;
            }
        }
        studioBean.setNumberOfJRooms(a);
        studioBean.setNumberOfRRooms(b);
        sdPage.setStudio(studioBean);
        return sdPage;
    }
    public ArrayList<StudioBean> getAllStudios(){
        return dataStudios.getAllStudios();
    }
    public StudioBean getStudio(){
        return studioBean;
    }
    public void setStudio(StudioBean s){
        studioBean = s;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public boolean getAdmin(){
        if(user.getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }
    
}
