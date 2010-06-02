/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import java.util.List;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.service.ILoggedUser;

/**
 *
 * @author Baxter
 */
public class AddStudios {

    private String studioID;
    private String studioName;
    private String studioAddress;
    private List<Room> rooms;
    @Persist("flash")
    private String name;

    @Inject
    private ILoggedUser lu;
    
    private Studio studio;

    @Inject
    private IDataStudiosService a;

    @InjectPage
    private AddStudios page;
    
    Object onActivate()
    {
        if (lu.getAllUsers().isEmpty()) {
            return Index.class;
        }
        else if(lu.getFirst().getPrivilege().equals(Privilege.User)){
            return Studios.class;
        }
        else return null;
    }
    public String getStudioAddress() {
        return studioAddress;
    }

    public void setStudioAddress(String studioAddress) {
        this.studioAddress = studioAddress;
    }

    public String getStudioID() {
        return studioID;
    }

    public void setStudioID(String studioID) {
        this.studioID = studioID;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    Object onSubmitFromAddStudioForm(){
        System.out.println("Handling form submission!");
        studio = new StudioBean();
        studio.setStudioID(studioID);
        studio.setStudioName(studioName);
        studio.setStudioAddress(studioAddress);

        if(!a.getAllStudios().contains(studio)){
            a.addStudioBean(studio);
            page.setName("Studio "+studio.getStudioName()+" is successfuly added!");
        }
        else{
            page.setName("Studio exists!!!");
        }
        return page;
    }
}
