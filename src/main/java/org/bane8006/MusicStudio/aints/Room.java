/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.aints;

import org.bane8006.MusicStudio.beans.RoomType;

/**
 *
 * @author Baxter
 */
public interface Room {
    
    public String getRoomID();

    public void setRoomID(String roomID);

    public String getRoomName();

    public void setRoomName(String roomName);

    public RoomType getRoomType();

    public void setRoomType(RoomType roomType);

    public String getDescription();

    public void setDescription(String description);

    public boolean equals(Object o);
}
