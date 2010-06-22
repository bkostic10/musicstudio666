/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.bane8006.MusicStudio.Booking;
import org.bane8006.MusicStudio.Room;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class RoomBean implements Room, Serializable{
    @Id
    @GeneratedValue
    private long id;
//@Column(name = "roomID",nullable=false,unique=true)
    @Basic
    private String roomID;
    @Basic
    private String roomName;
    @Basic
    private RoomType roomType;
    @Basic
    private String description;
    @OneToMany(targetEntity=BookingBean.class,cascade=CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<Booking>();

    
    public long getIdRoom() {
        return id;
    }

    public RoomBean() {
    }

    public RoomBean(String roomID, String roomName, RoomType roomType, String description) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomType = roomType;
        this.description = description;
    }

    
    public String getRoomID() {
        return roomID;
    }

    
    public void setRoomID(String roomID) {
        assert roomID!=null;
        assert !roomID.equals(" ");
        assert !roomID.equals("");
        this.roomID = roomID;
    }

    
    public String getRoomName() {
        return roomName;
    }

    
    public void setRoomName(String roomName) {
        assert roomName!=null;
        assert !roomName.equals(" ");
        assert !roomName.equals("");
        this.roomName = roomName;
    }

    
    public RoomType getRoomType() {
        return roomType;
    }

    
    public void setRoomType(RoomType roomType) {
        assert roomType!=null;
        this.roomType = roomType;
    }

    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        assert description!=null;
        assert !description.equals("");
        assert !description.equals(" ");
        this.description = description;
    }

    @Override
    public boolean equals(Object o){
        Room r = (RoomBean)(o);
        if(roomID.equals(r.getRoomID())){return true;}
            else return false;
    }
    
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }


    
    public Collection<Booking> getAllBookings() {
        return bookings;
    }

    
    public Booking getBookingById(Serializable id) {
        for(Booking b:getAllBookings()){
            if(b.getIdBooking()==(Long)id)
                return b;
        }
        return null;
    }
    
    public Booking addBooking(Booking rb) {
        if(!getAllBookings().contains(rb)){
            assert rb != null;
            assert rb.getBookingDate() != null;
            assert !rb.getBookingDate().equals(" ");
            assert !rb.getBookingDate().equals("");
            assert rb.getBookingTime() != null;
            bookings.add(rb);
            return rb;
        }
        else return null;
    }
    
    public void deleteBooking(Booking b){
        bookings.remove(b);
    }
}