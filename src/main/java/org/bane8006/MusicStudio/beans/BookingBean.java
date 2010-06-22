/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.bane8006.MusicStudio.Booking;

/**
 *
 * @author Baxter
 */
@Entity
public class BookingBean implements Booking, Serializable{
    @Id
    @GeneratedValue
    private long id;
    @Basic
    private String bookingDate;
    @Basic
    private Time bookingTime;
    @Basic
    private String username;

    public BookingBean() {
    }

    public BookingBean(long id, String bookingDate, Time bookingTime, String username) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.username = username;
    }

    
    public long getIdBooking() {
        return id;
    }

    
    public String getBookingDate() {
        return bookingDate;
    }

    
    public void setBookingDate(String bookingDate) {
        assert bookingDate!=null;
        assert !bookingDate.equals("");
        assert !bookingDate.equals(" ");
        this.bookingDate = bookingDate;
    }

    
    public Time getBookingTime() {
        return bookingTime;
    }

    
    public void setBookingTime(Time bookingTime) {
        assert bookingTime!=null;
        this.bookingTime = bookingTime;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        assert username!=null;
        assert !username.equals("");
        assert !username.equals(" ");
        this.username = username;
    }

    @Override
    public boolean equals(Object o){
        Booking b = (BookingBean)(o);
        if(b.getBookingDate().equals(bookingDate)&&b.getBookingTime()==bookingTime){return true;}
            else return false;
    }
}