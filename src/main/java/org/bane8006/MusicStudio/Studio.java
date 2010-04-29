/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
/**
 *
 * @author Baxter
 */
public interface Studio {
    
    public long getIdStudio();
    
    public int getNumberOfJRooms();

    public int getNumberOfRRooms();

    public String getStudioAddress();

    public void setStudioAddress(String studioAddress);

    public String getStudioID();

    public void setStudioID(String studioID);

    public String getStudioName();

    public void setStudioName(String studioName);

    public int getNumberOfRooms();

    @Override
    public boolean equals(Object o);
   
    public Collection<Room> getAllRooms();

    public Room getRoomById(Serializable id);

    public Room addRoom(Room rb);

    public void deleteRoom(Room r);

    public void setRooms(List<Room> rooms);
}
