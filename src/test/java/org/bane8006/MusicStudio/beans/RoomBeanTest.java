/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;
import org.bane8006.MusicStudio.Room;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertSame;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Baxter
 */
public class RoomBeanTest {
    private Room roomUnderTest;

    @BeforeMethod
    public void setUp() {
        roomUnderTest = new RoomBean();
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
}