/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;


@Entity
public class StudioBean implements Studio{

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "studioID",nullable=false,unique=true)
    private String studioID;
    @Basic
    private String studioName;
    @Basic
    private String studioAddress;
    @OneToMany(targetEntity=RoomBean.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Room> rooms = new ArrayList<Room>();

    @Override
    public long getIdStudio() {
        return id;
    }
    
    public StudioBean(String studioID, String studioName, String studioAddress) {
        this.studioID = studioID;
        this.studioName = studioName;
        this.studioAddress = studioAddress;
    }

    public StudioBean(){
        
    }

    @Override
    public int getNumberOfJRooms() {
        int a = 0;
        for (int i = 0; i < getAllRooms().size(); i++) {
            if(rooms.get(i).getRoomType()==RoomType.Jamming){
                a++;
            }        
        }
        return a;
    }

    @Override
    public int getNumberOfRRooms() {
        int a = 0;
        for (int i = 0; i < getAllRooms().size(); i++) {
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
    public Room getRoomById(Serializable id) {
        for(Room rb:getAllRooms()){
            if(rb.getIdRoom()==id)
                return rb;
        }
        return null;
    }
    @Override
    public Room addRoom(Room rb) {
        if(!getAllRooms().contains(rb)){
            assert rb != null;
            assert rb.getRoomID() != null;
            assert !rb.getRoomID().equals(" ");
            assert !rb.getRoomID().equals("");
            rooms.add(rb);
            return rb;
        }
        else return null;
    }
    @Override
    public void deleteRoom(Room r){
        rooms.remove(r);
    }
}
