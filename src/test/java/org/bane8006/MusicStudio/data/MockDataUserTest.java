/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;
import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.User;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertSame;
import static org.testng.AssertJUnit.assertNull;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Baxter
 */
public class MockDataUserTest {

    private IDataUser usersUnderTest;
    private List<User> users;

    @BeforeMethod
    public void setUp() {
        users = new ArrayList<User>();
        usersUnderTest = new MockDataUser(users);
    }

    @Test
    public void testGetAllUsers(){
        assertSame(users, usersUnderTest.getAllUsers());
    }
    @Test
    public void testGetUserByUserName(){
        User user = mock(User.class);
        String firstName = "Pera";
        String lastName = "Pampur";
        String userName = "admin";
        String password = "admin";
	when(user.getUserName()).thenReturn(userName);
        when(user.getFirstName()).thenReturn(firstName);
        when(user.getLastName()).thenReturn(lastName);
        when(user.getPassword()).thenReturn(password);
	usersUnderTest.addUser(user);
	assertSame(usersUnderTest.getUserByUserName(userName),user);
        assertNull(usersUnderTest.getUserByUserName("Other username"));
    }
    @Test
    public void testAddUser(){
        User user = mock(User.class);
        String firstName = "Pera";
        String lastName = "Pampur";
        String userName = "admin";
        String password = "admin";
	when(user.getUserName()).thenReturn(userName);
        when(user.getFirstName()).thenReturn(firstName);
        when(user.getLastName()).thenReturn(lastName);
        when(user.getPassword()).thenReturn(password);
	usersUnderTest.addUser(user);
	assertSame(usersUnderTest.getUserByUserName(userName),user);
    }
    @Test(expectedExceptions=AssertionError.class)
    public void testAddUserInvalid() {
        User user = mock(User.class);
	String userName = "aaaa";
	when(user.getUserName()).thenReturn(userName);
	usersUnderTest.addUser(user);
    }
    @Test
    public void testReplace(){
        User user = mock(User.class);
        String firstName = "Pera";
        String lastName = "Pampur";
        String userName = "admin";
        String userName2 = "oldUsername";
        String password = "admin";
	when(user.getUserName()).thenReturn(userName);
        when(user.getFirstName()).thenReturn(firstName);
        when(user.getLastName()).thenReturn(lastName);
        when(user.getPassword()).thenReturn(password);
	usersUnderTest.replace(usersUnderTest.getUserByUserName(userName2),user);
        usersUnderTest.addUser(user);
	assertSame(usersUnderTest.getUserByUserName(userName),user);
    }
    @Test
    public void testRemove(){
        User user = mock(User.class);
	String userName = "admin";
	when(user.getUserName()).thenReturn(userName);
	usersUnderTest.remove(user);
	assertSame(usersUnderTest.getUserByUserName(userName), null);
    }
    @Test
    public void testAuthenticate(){
        User user = mock(User.class);
        String firstName = "Pera";
        String lastName = "Pampur";
        String userName = "admin";
        String password = "admin";
	when(user.getUserName()).thenReturn(userName);
        when(user.getFirstName()).thenReturn(firstName);
        when(user.getLastName()).thenReturn(lastName);
        when(user.getPassword()).thenReturn(password);
        usersUnderTest.addUser(user);
	assertSame(usersUnderTest.authenticate(userName, password),user);
    }
}
