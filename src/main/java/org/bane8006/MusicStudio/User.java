/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio;

import org.bane8006.MusicStudio.beans.Privilege;

/**
 *
 * @author Baxter
 */
public interface User {

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getPersonalNumber();
    
    public void setPersonalNumber(String personalNumber);

    public String getPassword();

    public void setPassword(String password);

    public String getUserName();

    public void setUserName(String userName);

    public Privilege getPrivilege();

    public void setPrivilege(Privilege privilege);
    
    public long getIdUser();
}