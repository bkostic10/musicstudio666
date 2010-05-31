/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;
import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.Booking;
import org.bane8006.MusicStudio.Room;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertSame;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 *
 * @author Baxter
 */
public class RoomBeanTest {
    private Room roomUnderTest;
    private List<Booking> bookings;
    @BeforeMethod
    public void setUp() {
        bookings = new ArrayList<Booking>();
        roomUnderTest = new RoomBean();
        roomUnderTest.setBookings(bookings);
    }

    @Test
    public void testRoomID() {
        assertNull(roomUnderTest.getRoomID());
        String roomID = "001001";
        roomUnderTest.setRoomID(roomID);
        assertSame(roomID, roomUnderTest.getRoomID());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRoomIDInvalid() {
        assertNull(roomUnderTest.getRoomID());
        String roomID = "";
        roomUnderTest.setRoomID(roomID);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRoomIDInvalid2() {
        assertNull(roomUnderTest.getRoomID());
        String roomID = " ";
        roomUnderTest.setRoomID(roomID);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRoomIDInvalid3() {
        assertNull(roomUnderTest.getRoomID());
        String roomID = null;
        roomUnderTest.setRoomID(roomID);
    }

    @Test
    public void testRoomName() {
        assertNull(roomUnderTest.getRoomName());
        String roomName = "1st Room";
        roomUnderTest.setRoomName(roomName);
        assertSame(roomName, roomUnderTest.getRoomName());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRoomNameInvalid() {
        assertNull(roomUnderTest.getRoomName());
        String roomName = "";
        roomUnderTest.setRoomName(roomName);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRoomNameInvalid2() {
        assertNull(roomUnderTest.getRoomName());
        String roomName = " ";
        roomUnderTest.setRoomName(roomName);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRoomNameInvalid3() {
        assertNull(roomUnderTest.getRoomName());
        String roomName = null;
        roomUnderTest.setRoomName(roomName);
    }

    @Test
    public void testRoomType() {
        assertNull(roomUnderTest.getRoomType());
        RoomType rt = RoomType.Jamming;
        roomUnderTest.setRoomType(rt);
        assertSame(rt, roomUnderTest.getRoomType());
    }

    @Test
    public void testRoomType2() {
        assertNull(roomUnderTest.getRoomType());
        RoomType rt = RoomType.Recording;
        roomUnderTest.setRoomType(rt);
        assertSame(rt, roomUnderTest.getRoomType());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRoomTypeInvalid() {
        assertNull(roomUnderTest.getRoomType());
        RoomType rt = null;
        roomUnderTest.setRoomType(rt);
    }

    @Test
    public void testDescription() {
        assertNull(roomUnderTest.getDescription());
        String d = "Gear";
        roomUnderTest.setDescription(d);
        assertSame(d, roomUnderTest.getDescription());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testDescInvalid() {
        assertNull(roomUnderTest.getDescription());
        String d = null;
        roomUnderTest.setDescription(d);
    }
    @Test(expectedExceptions = AssertionError.class)
    public void testDescInvalid2() {
        assertNull(roomUnderTest.getDescription());
        String d = "";
        roomUnderTest.setDescription(d);
    }
    @Test(expectedExceptions = AssertionError.class)
    public void testDescInvalid3() {
        assertNull(roomUnderTest.getDescription());
        String d = " ";
        roomUnderTest.setDescription(d);
    }
    @Test
    public void testBookings(){
        assertNotNull(roomUnderTest.getAllBookings());

    }

    @Test
    public void testGetAllBookings(){
        assertSame(bookings, roomUnderTest.getAllBookings());
    }

    @Test
    public void testGetBookingById(){
        Booking booking = mock(BookingBean.class);
	long bookingID = booking.getIdBooking();
        String date = "05/30/2010";
        Time time = Time._10h_12h;
        when(booking.getIdBooking()).thenReturn(bookingID);
	when(booking.getBookingDate()).thenReturn(date);
        when(booking.getBookingTime()).thenReturn(time);
	roomUnderTest.addBooking(booking);
	assertSame(booking,roomUnderTest.getBookingById(bookingID));
        assertNull(roomUnderTest.getBookingById(0));
    }
    @Test
    public void testAddBooking(){
        Booking booking = mock(BookingBean.class);
        long bookingID = booking.getIdBooking();
        String date = "05/30/2010";
        Time time = Time._10h_12h;
        when(booking.getIdBooking()).thenReturn(bookingID);
	when(booking.getBookingDate()).thenReturn(date);
        when(booking.getBookingTime()).thenReturn(time);
	roomUnderTest.addBooking(booking);
	assertSame(booking,roomUnderTest.getBookingById(bookingID));
    }
    @Test
    public void testDeleteBooking(){
        Booking booking = mock(BookingBean.class);
        long bookingID = booking.getIdBooking();
        when(booking.getIdBooking()).thenReturn(bookingID);
	roomUnderTest.deleteBooking(booking);
	assertSame(roomUnderTest.getBookingById(bookingID), null);
    }
}