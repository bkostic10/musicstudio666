/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;


/**
 *
 * @author Baxter
 */
public class StudioBean implements Studio{
    private String studioID;
    private String studioName;
    private String studioAddress;
    private List<Room> rooms;


    public StudioBean(String studioID, String studioName, String studioAddress) {
        this.studioID = studioID;
        this.studioName = studioName;
        this.studioAddress = studioAddress;
    }
    public StudioBean(List<Room> rooms){
        super();
        this.rooms = rooms;
    }
    public StudioBean(){
        this(new ArrayList<Room>());
    }

    @Override
    public int getNumberOfJRooms() {
        int a = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getRoomType()==RoomType.Jamming){
                a++;
            }        
        }
        return a;
    }

    @Override
    public int getNumberOfRRooms() {
        int a = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getRoomType()==RoomType.Recording){
                a++;
            }
        }
        return a;
    }

    @Override
    public int getNumberOfRooms() {
        return rooms.size();
    }

    @Override
    public String getStudioAddress() {
        return studioAddress;
    }

    @Override
    public void setStudioAddress(String studioAddress) {
        assert studioAddress!=null;
        assert !studioAddress.equals(" ");
        assert !studioAddress.equals("");
        this.studioAddress = studioAddress;
    }

    @Override
    public String getStudioID() {
        return studioID;
    }

    @Override
    public void setStudioID(String studioID) {
        assert studioID!=null;
        assert !studioID.equals(" ");
        assert !studioID.equals("");
        this.studioID = studioID;
    }

    @Override
    public String getStudioName() {
        return studioName;
    }

    @Override
    public void setStudioName(String studioName) {
        assert studioName!=null;
        assert !studioName.equals(" ");
        assert !studioName.equals("");
        this.studioName = studioName;
    }
    @Override
    public boolean equals(Object o){
        Studio s = (StudioBean)(o);
        if(studioID.equals(s.getStudioID())){return true;}
        else return false;
    }

    @Override
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    

    @Override
    public Collection<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public Room getRoomById(String id) {
        for(Room rb:getAllRooms()){
            if(rb.getRoomID().equals(id))
                return rb;
        }
        return null;
    }
    @Override
    public void addRoom(Room rb) {
        if(!getAllRooms().contains(rb)){
            assert rb != null;
            assert rb.getRoomID() != null;
            assert !rb.getRoomID().equals(" ");
            assert !rb.getRoomID().equals("");
            rooms.add(rb);
        }
        else System.out.println("Room exists!");
    }
    @Override
    public void deleteRoom(Room r){
        rooms.remove(r);
    }
}
