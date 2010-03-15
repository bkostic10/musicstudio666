/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.beans.RoomType;


/**
 *
 * @author Baxter
 */
public class MockDataRooms implements IDataRooms{

    private static List<RoomBean> rooms = new ArrayList<RoomBean>();
    private static List<RoomBean> certainRooms = new ArrayList<RoomBean>();

    public MockDataRooms() {

        addRoomBean(new RoomBean("001001","1S - 1st Room","001",RoomType.Recording));
        addRoomBean(new RoomBean("001002","1S - 2nd Room","001",RoomType.Jamming));
        addRoomBean(new RoomBean("001003","1S - 3rd Room","001",RoomType.Jamming));
    }

    public int getNumberOfRooms(){
        return getCertainRooms().size();
    }

    public ArrayList<RoomBean> getCertainRooms() {
        return (ArrayList<RoomBean>) certainRooms;
    }

    public ArrayList<RoomBean> getAllRooms() {
        return (ArrayList<RoomBean>) rooms;
    }

    public RoomBean getRoomById(String id) {
        for(RoomBean rb:getAllRooms()){
            if(rb.getRoomID().equals(id))
                return rb;
        }
        return null;
    }
    public void addCertainRoomBean(RoomBean rb) {
        if(!getCertainRooms().contains(rb)){
            certainRooms.add(rb);
        }
        else System.out.println("Room exists!");
    }

    public void addRoomBean(RoomBean rb) {
        if(!getAllRooms().contains(rb)){
            rooms.add(rb);
        }
        else System.out.println("Room exists!");
    }
}
