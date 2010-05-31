/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bane8006.MusicStudio.Booking;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;

/**
 *
 * @author Baxter
 */
public class MockDataStudios implements IDataStudiosService{

    private List<Studio>studios;

    public MockDataStudios(List<Studio> studios) {
        super();
        this.studios = studios;
    }

    public MockDataStudios() {
        this(new ArrayList<Studio>());
        //load();
    }
    
    @Override
    public Collection<Studio> getAllStudios() {
        return studios;
    }

    @Override
    public Studio getStudioById(Serializable id) {
        for(Studio sb:getAllStudios()){
            if(sb.getStudioID().equals(id))
                return sb;
        }
        return null;
    }
    @Override
    public Studio addStudioBean(Studio sb) {
        if(!getAllStudios().contains(sb)){
            assert sb != null;
            assert sb.getStudioID() != null;
            assert !sb.getStudioID().equals(" ");
            assert !sb.getStudioID().equals("");
            studios.add(sb);
            return sb;
        }
        else return null;//System.out.println("Studio exists!");
    }
    @Override
    public void deleteStudio(Studio s){
        studios.remove(s);
    }

    @Override
    public void updateStudio(Studio s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteRoom(Studio s,Room r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void lockStudio(Studio s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteBooking(Studio s, Room r, Booking b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


//    @Override
//    public void load() {
//        List<Room> rooms = new ArrayList<Room>();
//        List<Room> rooms1 = new ArrayList<Room>();
//
//        Room r1 = new RoomBean("001001","1S - 1st Room",RoomType.Recording,"Studio 1 has:\nGuitar Head: Metal Head FENDER (x2)\nGuitar Speaker: 450W (4x12”)\nBass Head: Warvick\nBass Speaker: BEHRINGER (15”+2x12”)\nMixer: Yamaha 512 mx\nVoice Speaker: JBL 2 kutije (2x15”)\nDrums: Yamaha Stage Custom");
//        Room r2 = new RoomBean("001002","1S - 2nd Room",RoomType.Jamming,"Studio 2 has:\nGuitar Head: AVT 150H Marshall (x2)\nGuitar Speaker: 150W (4x12”)\nBass Head: Warvick Pro fet 3.2\nBass Speaker: BEHRINGER (4x10”)\nMixer: Yamaha 512 mx\nVoice Speaker: Behringerb (15”)\nDrums: TAMA");
//        Room r3 = new RoomBean("001003","1S - 3rd Room",RoomType.Jamming,"Studio 3 has:\nGuitar Head: /\nGuitar Speaker: Line 6 Spider III (x2)\nBass Head: Behringer BX4500H Ultrabass\nBass Speaker: Behringer (15”)\nMixer: Yamaha Stage pass\nVoice Speaker: Yamaha (2x250W)\nDrums: Yamaha Rydeen");
//
//        Room r11 = new RoomBean("002001","2S - 1st Room",RoomType.Recording,"Studio 1 has:\nGuitar Head: Metal Head FENDER (x2)\nGuitar Speaker: 450W (4x12”)\nBass Head: Warvick\nBass Speaker: BEHRINGER (15”+2x12”)\nMixer: Yamaha 512 mx\nVoice Speaker: JBL 2 kutije (2x15”)\nDrums: Yamaha Stage Custom");
//        Room r21 = new RoomBean("002002","2S - 2nd Room",RoomType.Jamming,"Studio 2 has:\nGuitar Head: AVT 150H Marshall (x2)\nGuitar Speaker: 150W (4x12”)\nBass Head: Warvick Pro fet 3.2\nBass Speaker: BEHRINGER (4x10”)\nMixer: Yamaha 512 mx\nVoice Speaker: Behringerb (15”)\nDrums: TAMA");
//        Room r31 = new RoomBean("002003","2S - 3rd Room",RoomType.Jamming,"Studio 3 has:\nGuitar Head: /\nGuitar Speaker: Line 6 Spider III (x2)\nBass Head: Behringer BX4500H Ultrabass\nBass Speaker: Behringer (15”)\nMixer: Yamaha Stage pass\nVoice Speaker: Yamaha (2x250W)\nDrums: Yamaha Rydeen");
//
//
//        Studio s1 = new StudioBean();
//        s1.setStudioID("001");
//        s1.setStudioName("1st Studio");
//        s1.setStudioAddress("AA1");
//        Studio s2 = new StudioBean();
//        s2.setStudioID("002");
//        s2.setStudioName("2nd Studio");
//        s2.setStudioAddress("AA2");
//        rooms.add(r1);
//        rooms.add(r2);
//        rooms.add(r3);
//        rooms1.add(r11);
//        rooms1.add(r21);
//        rooms1.add(r31);
//        s1.setRooms(rooms);
//        s2.setRooms(rooms1);
//        addStudioBean(s1);
//        addStudioBean(s2);
//    }
}
