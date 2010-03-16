/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import org.bane8006.MusicStudio.beans.RoomBean;


/**
 *
 * @author Baxter
 */
public interface IDataRooms {

    public ArrayList<RoomBean> getAllRooms();
    public ArrayList<RoomBean> getCertainRooms();
    public void addCertainRoomBean(RoomBean rb);
    public RoomBean getRoomById(String id);
    public void addRoomBean(RoomBean rb);
    public void deleteRoom(RoomBean r);
}
