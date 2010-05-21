/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.service.ILoggedUser;

/**
 *
 * @author Baxter
 */
public class Rooms {

    private Serializable id;

    private Studio studio;

    @Inject
    private ILoggedUser lu;

    @Inject
    private IDataStudiosService ds;

    @InjectPage
    private RoomDetails rdPage;

    @InjectPage
    private StudioDetails sdPage;

    @Persist("flash")
    private String name;

    private Room room;
    
    Object onActivate()
    {
        if (lu.getAllUsers().isEmpty()){
            return Index.class;
        }
        else return null;
    }
    @OnEvent(component="roomDetailsLink")
    Object onShowDetails(long id){
        Room room = studio.getRoomById(id);
        rdPage.setId(id);
        rdPage.setIdStudio(studio.getIdStudio());
        return rdPage;
    }
    @OnEvent(component="backLink")
    Object onBack(long id){
        sdPage.setId(studio.getIdStudio());
        return sdPage;
    }
    void onActivate(long id){
        System.out.println("Activated:"+id);
        this.id = id; 
        setStudio(ds.getStudioById(id));
    }
    Serializable onPassivate(){
        return id;
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
    public User getUser(){
        return lu.getFirst();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

}
