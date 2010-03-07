/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.util.ArrayList;
import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.data.MockDataStudios;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class Studios {
    @ApplicationState
    private String userWelcome;

    @ApplicationState
    private User user;
    private boolean userExists;

    @ApplicationState
    private MockDataStudios dataStudios;

    @InjectPage
    private StudioDetails sdPage;

    private StudioBean studioBean;


    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }
    void onActivate(String fullName){
        System.out.println("Activated:"+fullName);
        this.userWelcome = fullName;
    }
    String onPassivate(){
        return userWelcome;
    }

    @OnEvent(component="studioDetailsLink")
    Object onShowDetails(String name){
        StudioBean studioBean = dataStudios.getStudioByName(name);
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

    public String getUserWelcome() {
        return userWelcome;
    }

    public void setUserWelcome(String userWelcome) {
        this.userWelcome = userWelcome;
    }  
    
}
