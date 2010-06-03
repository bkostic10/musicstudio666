/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.pages;

import java.io.Serializable;
import java.util.Date;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;
import org.bane8006.MusicStudio.Booking;
import org.bane8006.MusicStudio.beans.Privilege;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.User;
import org.bane8006.MusicStudio.beans.BookingBean;
import org.bane8006.MusicStudio.beans.Time;
import org.bane8006.MusicStudio.service.ILoggedUser;

/**
 *
 * @author Baxter
 */
public class RoomDetails {

    @Component(id="bookRoomForm")
    private Form form;

    private long id;

    @Persist
    private Serializable idStudio;

    @Property
    private Room room;

    @Property
    private Booking booking;

    @Inject
    private IDataStudiosService dataStudios;

    @Inject
    private ILoggedUser lu;

    @Inject
    private Messages message;

    @Property
    private Studio studio;

    @InjectPage
    private Rooms page;

    @InjectPage
    private Rooms rooms;
    private Date bookingDate;
    private Time bookingTime = Time._10h_12h;

    @Persist("flash")
    private String answer;
    @InjectPage
    private RoomDetails thisPage;

    Object onActivate()
    {
        if (lu.getAllUsers().isEmpty()) return Index.class;
        return null;
    }

    @OnEvent(component="backLink")
    Object onBack(long id){
        page.setId(studio.getIdStudio());
        return page;
    }
    @OnEvent(component="deleteRoomLink")
    Object onDeleteRoom(long id){
        Room room = studio.getRoomById(id);
        page.setName(room.getRoomName()+" has been successfuly deleted!");
        studio.getAllRooms().remove(room);
        dataStudios.deleteRoom(studio, room);
        rooms.setId(studio.getIdStudio());
        return page;
    }
    @OnEvent(component="cancelResLink")
    Object onCancelRes(long id){
        Booking b = room.getBookingById(id);
        room.getAllBookings().remove(b);
        dataStudios.deleteBooking(studio, room, b);
        return thisPage;
    }
    void onActivate(long id){
        System.out.println("Activated:"+id);
        this.id = id;
        studio = dataStudios.getStudioById(idStudio);
        room = studio.getRoomById(id);
    }
    Serializable onPassivate(){
        return id;
    }
    public User getUser(){
        return lu.getFirst();
    }
    public boolean getAdmin(){
        if(getUser().getPrivilege().equals(Privilege.Admin))
            return true;
        else return false;
    }
    public boolean getCompatibility(){
        if(booking.getUsername().equals(getUser().getUserName()))
            return true;
        else return false;
    }

    void setId(long id) {
        this.id = id;
    }

    public void setIdStudio(Serializable idStudio) {
        this.idStudio = idStudio;
    }

    public long getId() {
        return id;
    }

    public Serializable getIdStudio() {
        return idStudio;
    }
    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date date) {
        this.bookingDate = date;
    }
    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time time) {
        this.bookingTime = time;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public SelectModel getTimeModel() {
        return new EnumSelectModel(Time.class, message);
    }
    void onValidateFromBookRoomForm() {
        String db = String.valueOf(bookingDate);
        String dd = db.substring(0, 10)+" "+db.substring(db.length()-4, db.length());
        for(Booking b:room.getAllBookings()){
            if(b.getBookingDate().equals(dd)&&b.getBookingTime().equals(bookingTime)){
                form.recordError("Booking exists");
            }
        }
    }
    void onSuccessFromBookRoomForm() {
        Booking b = new BookingBean();
        String db = String.valueOf(bookingDate);
        String dd = db.substring(0, 10)+" "+db.substring(db.length()-4, db.length());
        b.setBookingDate(dd);
        b.setBookingTime(bookingTime);
        String user = lu.getFirst().getUserName();
        b.setUsername(user);
        room.addBooking(b);
        dataStudios.updateStudio(studio);
        thisPage.setIdStudio(idStudio);
        thisPage.setId(id);
        System.out.println("Booking added");
        thisPage.setAnswer("Booking added");
    }
}
