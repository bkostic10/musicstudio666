/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio;

import org.bane8006.MusicStudio.beans.RoomType;

/**
 *
 * @author Baxter
 */
public interface Room {
    
    public long getIdRoom();

    public String getRoomID();

    public void setRoomID(String roomID);

    public String getRoomName();

    public void setRoomName(String roomName);

    public RoomType getRoomType();

    public void setRoomType(RoomType roomType);

    public String getDescription();

    public void setDescription(String description);

    @Override
    public boolean equals(Object o);
}
