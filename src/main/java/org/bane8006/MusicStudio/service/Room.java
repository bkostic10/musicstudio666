/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

/**
 *
 * @author Baxter
 */
public interface Room {
    
    public String getRoomID();

    public void setRoomID(String roomID);

    public String getRoomName();

    public void setRoomName(String roomName);

    public String getStudioID();

    public void setStudioID(String studioID);

        public boolean equals(Object o);
}
