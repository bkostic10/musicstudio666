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

        addRoomBean(new RoomBean("001001","1S - 1st Room","001",RoomType.Recording,"Studio 1 has:\nGuitar Head: Metal Head FENDER (x2)\nGuitar Speaker: 450W (4x12”)\nBass Head: Warvick\nBass Speaker: BEHRINGER (15”+2x12”)\nMixer: Yamaha 512 mx\nVoice Speaker: JBL 2 kutije (2x15”)\nDrums: Yamaha Stage Custom"));
        addRoomBean(new RoomBean("001002","1S - 2nd Room","001",RoomType.Jamming,"Studio 2 has:\nGuitar Head: AVT 150H Marshall (x2)\nGuitar Speaker: 150W (4x12”)\nBass Head: Warvick Pro fet 3.2\nBass Speaker: BEHRINGER (4x10”)\nMixer: Yamaha 512 mx\nVoice Speaker: Behringerb (15”)\nDrums: TAMA"));
        addRoomBean(new RoomBean("001003","1S - 3rd Room","001",RoomType.Jamming,"Studio 3 has:\nGuitar Head: /\nGuitar Speaker: Line 6 Spider III (x2)\nBass Head: Behringer BX4500H Ultrabass\nBass Speaker: Behringer (15”)\nMixer: Yamaha Stage pass\nVoice Speaker: Yamaha (2x250W)\nDrums: Yamaha Rydeen"));
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
