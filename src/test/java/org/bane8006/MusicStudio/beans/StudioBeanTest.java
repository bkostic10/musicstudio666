/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;
import org.bane8006.MusicStudio.Room;
import static org.testng.AssertJUnit.assertNotNull;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.Studio;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertSame;
import static org.testng.AssertJUnit.assertNull;
/**
 *
 * @author Baxter
 */
public class StudioBeanTest {
    private Studio studioUnderTest;
    private List<Room> rooms;

    @BeforeMethod
    public void setUp() {
        rooms = new ArrayList<Room>();
        studioUnderTest = new StudioBean(rooms);
    }

    @Test
    public void testStudioID() {
        assertNull(studioUnderTest.getStudioID());
        String studioID = "001";
        studioUnderTest.setStudioID(studioID);
        assertSame(studioID, studioUnderTest.getStudioID());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioIDInvalid() {
        assertNull(studioUnderTest.getStudioID());
        String studioID = "";
        studioUnderTest.setStudioID(studioID);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioIDInvalid2() {
        assertNull(studioUnderTest.getStudioID());
        String studioID = " ";
        studioUnderTest.setStudioID(studioID);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioIDInvalid3() {
        assertNull(studioUnderTest.getStudioID());
        String studioID = null;
        studioUnderTest.setStudioID(studioID);
    }

    @Test
    public void testStudioName() {
        assertNull(studioUnderTest.getStudioName());
        String studioName = "1st Studio";
        studioUnderTest.setStudioName(studioName);
        assertSame(studioName, studioUnderTest.getStudioName());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioNameInvalid() {
        assertNull(studioUnderTest.getStudioName());
        String studioName = "";
        studioUnderTest.setStudioName(studioName);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioNameInvalid2() {
        assertNull(studioUnderTest.getStudioName());
        String studioName = " ";
        studioUnderTest.setStudioName(studioName);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioNameInvalid3() {
        assertNull(studioUnderTest.getStudioName());
        String studioName = null;
        studioUnderTest.setStudioName(studioName);
    }

    @Test
    public void testStudioAddress() {
        assertNull(studioUnderTest.getStudioAddress());
        String studioAddress = "AA 1";
        studioUnderTest.setStudioAddress(studioAddress);
        assertSame(studioAddress, studioUnderTest.getStudioAddress());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioAddressInvalid() {
        assertNull(studioUnderTest.getStudioAddress());
        String studioAddress = "";
        studioUnderTest.setStudioAddress(studioAddress);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioAddressInvalid2() {
        assertNull(studioUnderTest.getStudioAddress());
        String studioAddress = " ";
        studioUnderTest.setStudioAddress(studioAddress);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testStudioAddressInvalid3() {
        assertNull(studioUnderTest.getStudioAddress());
        String studioAddress = null;
        studioUnderTest.setStudioAddress(studioAddress);
    }
    
    @Test
    public void testRooms(){
        assertNotNull(studioUnderTest.getAllRooms());

    }

    @Test
    public void testGetAllRooms(){
        assertSame(rooms, studioUnderTest.getAllRooms());
    }

    @Test
    public void testGetRoomById(){
        Room room = mock(Room.class);
	String roomID = "001001";
        String roomName = "1S - 1st Studio";
        RoomType roomType = RoomType.Jamming;
	when(room.getRoomID()).thenReturn(roomID);
        when(room.getRoomName()).thenReturn(roomName);
        when(room.getRoomType()).thenReturn(roomType);
	studioUnderTest.addRoom(room);
	assertSame(room,studioUnderTest.getRoomById(roomID));
        assertNull(studioUnderTest.getRoomById("Other ID"));
    }
    @Test
    public void testAddRoom(){
        Room room = mock(Room.class);
	String roomID = "001001";
        String roomName = "1S - 1st Studio";
        RoomType roomType = RoomType.Jamming;
	when(room.getRoomID()).thenReturn(roomID);
        when(room.getRoomName()).thenReturn(roomName);
        when(room.getRoomType()).thenReturn(roomType);
	studioUnderTest.addRoom(room);
	assertSame(room,studioUnderTest.getRoomById(roomID));
    }
    @Test
    public void testDeleteRoom(){
        Room room = mock(Room.class);
	String roomID = "001001";
	when(room.getRoomID()).thenReturn(roomID);
	studioUnderTest.deleteRoom(room);
	assertSame(studioUnderTest.getRoomById(roomID), null);
    }
}
