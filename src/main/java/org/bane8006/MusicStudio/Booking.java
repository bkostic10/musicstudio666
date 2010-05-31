/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio;

import org.bane8006.MusicStudio.beans.Time;

/**
 *
 * @author Baxter
 */
public interface Booking {
    public long getIdBooking();

    public String getBookingDate();

    public void setBookingDate(String bookingDate);

    public Time getBookingTime();

    public void setBookingTime(Time bookingTime);

    public String getUsername();

    public void setUsername(String username);
    
    @Override
    public boolean equals(Object o);
}
