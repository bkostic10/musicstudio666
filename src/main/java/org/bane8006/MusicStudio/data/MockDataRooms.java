/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.beans.RoomBean;


/**
 *
 * @author Baxter
 */
public class MockDataRooms implements IDataRooms{

    private List<RoomBean> rooms = new ArrayList<RoomBean>();

    public MockDataRooms() {

        addRoomBean(new RoomBean("001001","Jedan",false));
        addRoomBean(new RoomBean("001002","Dva",false));
    }

    public ArrayList<RoomBean> getAllRooms() {
        return (ArrayList<RoomBean>) rooms;
    }

    public RoomBean getRoomByName(String name) {
        for(RoomBean rb:rooms){
            if(rb.getRoomName().equals(name))
                return rb;
        }
        return null;
    }

    public void addRoomBean(RoomBean rb) {
        rooms.add(rb);
    }
}
