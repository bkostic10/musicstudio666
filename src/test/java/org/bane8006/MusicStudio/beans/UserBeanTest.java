/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;
import org.bane8006.MusicStudio.User;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertSame;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Baxter
 */
public class UserBeanTest {
    private User userUnderTest;
    
    @BeforeMethod
    public void setUp() {
        userUnderTest = new UserBean();
    }

    @Test
    public void testFirstName() {
        assertNull(userUnderTest.getFirstName());
        String firstName = "Freddie";
        userUnderTest.setFirstName(firstName);
        assertSame(firstName, userUnderTest.getFirstName());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testFirstNameInvalid() {
        assertNull(userUnderTest.getFirstName());
        String name = "";
        userUnderTest.setFirstName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testFirstNameInvalid2() {
        assertNull(userUnderTest.getFirstName());
        String name = " ";
        userUnderTest.setFirstName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testFirstNameInvalid3() {
        assertNull(userUnderTest.getFirstName());
        String name = null;
        userUnderTest.setFirstName(name);
    }

    @Test
    public void testLastName() {
        assertNull(userUnderTest.getLastName());
        String lastName = "Mercury";
        userUnderTest.setLastName(lastName);
        assertSame(lastName, userUnderTest.getLastName());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testLastNameInvalid() {
        assertNull(userUnderTest.getLastName());
        String name = "";
        userUnderTest.setLastName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testLastNameInvalid2() {
        assertNull(userUnderTest.getLastName());
        String name = " ";
        userUnderTest.setLastName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testLastNameInvalid3() {
        assertNull(userUnderTest.getLastName());
        String name = null;
        userUnderTest.setLastName(name);
    }

    @Test
    public void testUserName() {
        assertNull(userUnderTest.getUserName());
        String userName = "mika55";
        userUnderTest.setUserName(userName);
        assertSame(userName, userUnderTest.getUserName());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testUserNameInvalid() {
        assertNull(userUnderTest.getUserName());
        String name = "";
        userUnderTest.setUserName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testUserNameInvalid2() {
        assertNull(userUnderTest.getUserName());
        String name = " ";
        userUnderTest.setUserName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testUserNameInvalid3() {
        assertNull(userUnderTest.getUserName());
        String name = null;
        userUnderTest.setUserName(name);
    }

    @Test
    public void testPassword() {
        assertNull(userUnderTest.getPassword());
        String pass = "mika55";
        userUnderTest.setPassword(pass);
        assertSame(pass, userUnderTest.getPassword());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testPasswordInvalid() {
        assertNull(userUnderTest.getPassword());
        String name = "";
        userUnderTest.setPassword(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testPasswordInvalid2() {
        assertNull(userUnderTest.getPassword());
        String name = " ";
        userUnderTest.setPassword(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testPasswordInvalid3() {
        assertNull(userUnderTest.getPassword());
        String name = null;
        userUnderTest.setPassword(name);
    }

    @Test
    public void testPrivilege() {
        assertNull(userUnderTest.getPrivilege());
        Privilege p = Privilege.User;
        userUnderTest.setPrivilege(p);
        assertSame(p, userUnderTest.getPrivilege());
    }

    @Test
    public void testPrivilege2() {
        assertNull(userUnderTest.getPrivilege());
        Privilege p = Privilege.Owner;
        userUnderTest.setPrivilege(p);
        assertSame(p, userUnderTest.getPrivilege());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testPrivilegeInvalid() {
        assertNull(userUnderTest.getPrivilege());
        Privilege p = null;
        userUnderTest.setPrivilege(p);
    }
}
