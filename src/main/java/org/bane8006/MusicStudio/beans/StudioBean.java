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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;


@Entity
public class StudioBean implements Studio, Serializable{

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "studioID",nullable=false,unique=true)
    private String studioID;
    @Basic
    private String studioName;
    @Basic
    private String studioAddress;
    @OneToMany(targetEntity=RoomBean.class,cascade=CascadeType.ALL)
    private List<Room> rooms = new ArrayList<Room>();

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

    
    public int getNumberOfJRooms() {
        int a = 0;
        for(Room r:rooms){
            if(r.getRoomType()==RoomType.Jamming){
                a++;
            }
        }
        return a;
    }

    
    public int getNumberOfRRooms() {
        int a = 0;
        for(Room r:rooms){
            if(r.getRoomType()==RoomType.Recording){
                a++;
            }
        }
        return a;
    }

    
    public int getNumberOfRooms() {
        return rooms.size();
    }

    
    public String getStudioAddress() {
        return studioAddress;
    }

    
    public void setStudioAddress(String studioAddress) {
        assert studioAddress!=null;
        assert !studioAddress.equals(" ");
        assert !studioAddress.equals("");
        this.studioAddress = studioAddress;
    }

    
    public String getStudioID() {
        return studioID;
    }

    
    public void setStudioID(String studioID) {
        assert studioID!=null;
        assert !studioID.equals(" ");
        assert !studioID.equals("");
        this.studioID = studioID;
    }

    
    public String getStudioName() {
        return studioName;
    }

    
    public void setStudioName(String studioName) {
        assert studioName!=null;
        assert !studioName.equals(" ");
        assert !studioName.equals("");
        this.studioName = studioName;
    }
    
    public boolean equals(Object o){
        Studio s = (StudioBean)(o);
        if(studioID.equals(s.getStudioID())){return true;}
        else return false;
    }

    
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    

    
    public Collection<Room> getAllRooms() {
        return rooms;
    }

    
    public Room getRoomById(Serializable id) {
        for(Room rb:getAllRooms()){
            if(rb.getIdRoom()==(Long)id)
                return rb;
        }
        return null;
    }
    
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
    
    public void deleteRoom(Room r){
        rooms.remove(r);
    }
}
