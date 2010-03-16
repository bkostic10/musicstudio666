/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;



import org.apache.tapestry5.annotations.ApplicationState;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
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
public class StudioDetails {

    @Persist
    private Studio s;

    @InjectPage
    private Rooms r;

    @InjectPage
    private Studios st;

    @ApplicationState
    private User user;
    private boolean userExists;

    Object onActivate()
    {
        if (!userExists) return Index.class;
        return null;
    }
    @OnEvent(component="roomsLink")
    Object onShowRooms(){
        return r;
    }
    @OnEvent(component="deleteStudioLink")
    Object onDeleteStudio(){
        IDataStudios ds = new MockDataStudios();
        ds.deleteStudio((StudioBean) s);
        return st;
    }
    public void setStudio(Studio s)
    {
        this.s = s;
    }
    public Studio getStudio()
    {
        return s;
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
