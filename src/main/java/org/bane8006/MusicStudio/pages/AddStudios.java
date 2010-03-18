/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.data.IDataStudios;
import org.bane8006.MusicStudio.data.MockDataStudios;
import org.bane8006.MusicStudio.service.Studio;
import org.bane8006.MusicStudio.service.User;

/**
 *
 * @author Baxter
 */
public class AddStudios {
    private String studioID;
    private String studioName;
    private String studioAddress;

    private String name;

    @ApplicationState
    private User user;
    private boolean userExists;

    @Persist
    private Studio studio;

    @Inject
    private IDataStudios a;

    @InjectPage
    private AddStudios page;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    void onActivate(String studio){
        System.out.println("Activated:"+studio);
        this.name = studio;
    }
    String onPassivate(){
        return name;
    }

    Object onSubmitFromAddStudioForm(){
        System.out.println("Handling form submission!");
        studio = new StudioBean();
        studio.setStudioID(studioID);
        studio.setStudioName(studioName);
        studio.setStudioAddress(studioAddress);

        if(!a.getAllStudios().contains((StudioBean)studio)){
            a.addStudioBean((StudioBean) studio);
            page.setName("Studio "+getStudioName()+" is successfuly added!");
        }
        else{
            page.setName("Studio exists!!!");
        }
        return page;
    }
}
