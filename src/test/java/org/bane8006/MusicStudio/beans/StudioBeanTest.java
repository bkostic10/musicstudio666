/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertSame;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Baxter
 */
public class StudioBeanTest {
    private StudioBean studioUnderTest;

    @BeforeMethod
    public void setUp() {
        studioUnderTest = new StudioBean();
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
    @Test(expectedExceptions = AssertionError.class)
    public void testJRooms() {
        assertNull(studioUnderTest.getNumberOfJRooms());
        int jr = 0;
        studioUnderTest.setNumberOfJRooms(jr);
        assertSame(jr, studioUnderTest.getNumberOfJRooms());
    }
    @Test(expectedExceptions = AssertionError.class)
    public void testRRooms() {
        assertNull(studioUnderTest.getNumberOfRRooms());
        int rr = 0;
        studioUnderTest.setNumberOfRRooms(rr);
        assertSame(rr, studioUnderTest.getNumberOfRRooms());
    }
}
