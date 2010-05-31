/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;
import org.bane8006.MusicStudio.Booking;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertSame;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Baxter
 */
public class BookingBeanTest {
    private Booking bookingUnderTest;
    @BeforeMethod
    public void setUp() {
        bookingUnderTest = new BookingBean();
    }

    @Test
    public void testDate() {
        assertNull(bookingUnderTest.getBookingDate());
        String date = "05/30/2010";
        bookingUnderTest.setBookingDate(date);
        assertSame(date, bookingUnderTest.getBookingDate());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testDateInvalid() {
        assertNull(bookingUnderTest.getBookingDate());
        String date = "";
        bookingUnderTest.setBookingDate(date);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testDateInvalid2() {
        assertNull(bookingUnderTest.getBookingDate());
        String date = " ";
        bookingUnderTest.setBookingDate(date);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testDateInvalid3() {
        assertNull(bookingUnderTest.getBookingDate());
        String date = null;
        bookingUnderTest.setBookingDate(date);
    }

    @Test
    public void testTime() {
        assertNull(bookingUnderTest.getBookingTime());
        Time t = Time._10h_12h;
        bookingUnderTest.setBookingTime(t);
        assertSame(t, bookingUnderTest.getBookingTime());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testTimeInvalid() {
        assertNull(bookingUnderTest.getBookingTime());
        Time t = null;
        bookingUnderTest.setBookingTime(t);
    }
    @Test
    public void testUserName() {
        assertNull(bookingUnderTest.getUsername());
        String userName = "mika55";
        bookingUnderTest.setUsername(userName);
        assertSame(userName, bookingUnderTest.getUsername());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testUserNameInvalid() {
        assertNull(bookingUnderTest.getUsername());
        String name = "";
        bookingUnderTest.setUsername(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testUserNameInvalid2() {
        assertNull(bookingUnderTest.getUsername());
        String name = " ";
        bookingUnderTest.setUsername(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testUserNameInvalid3() {
        assertNull(bookingUnderTest.getUsername());
        String name = null;
        bookingUnderTest.setUsername(name);
    }
}
