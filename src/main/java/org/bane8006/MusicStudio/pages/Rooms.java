/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.service.IDataStudiosService;

/**
 *
 * @author Baxter
 */
public class Rooms {

    private Serializable id;

    @Property
    private Studio studio;

    @Inject
    private IDataStudiosService ds;

    @InjectPage
    private RoomDetails rdPage;

    @InjectPage
    private StudioDetails sdPage;

    @Persist("flash")
    private String name;

    @Property
    private Room room;
    
    @ApplicationState
    @Property
    private User user;
    private boolean userExists;
    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
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
        studio = ds.getStudioById(id);

    }
    Serializable onPassivate(){
        return id;
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
