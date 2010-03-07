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
    public RoomBean getRoomByName(String name);
    public void addRoomBean(RoomBean rb);
}
