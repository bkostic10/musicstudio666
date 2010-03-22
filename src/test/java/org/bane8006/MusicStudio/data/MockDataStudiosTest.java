/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;
import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.service.Studio;
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
public class MockDataStudiosTest {
    private IDataStudios studiosUnderTest;
    private List<Studio> studios;

    @BeforeMethod
    public void setUp() {
        studios = new ArrayList<Studio>();
        studiosUnderTest = new MockDataStudios(studios);
    }

    @Test
    public void testAddStudioBean() {
        Studio studio = mock(Studio.class);
	String studioID = "001";
        String studioName = "1st Studio";
        String studioAddress = "AA 1";
	when(studio.getStudioID()).thenReturn(studioID);
        when(studio.getStudioName()).thenReturn(studioName);
        when(studio.getStudioAddress()).thenReturn(studioAddress);
	studiosUnderTest.addStudioBean(studio);
	assertSame(studiosUnderTest.getStudioById(studioID), studio);
    }

    @Test(expectedExceptions=AssertionError.class)
    public void testAddStudioInvalid() {
        Studio studio = mock(Studio.class);
	String studioID = "";
	when(studio.getStudioID()).thenReturn(studioID);
	studiosUnderTest.addStudioBean(studio);
    }
    @Test(expectedExceptions=AssertionError.class)
    public void testAddStudioInvalid2() {
        Studio studio = mock(Studio.class);
	String studioID = " ";
	when(studio.getStudioID()).thenReturn(studioID);
	studiosUnderTest.addStudioBean(studio);
    }
    @Test(expectedExceptions=AssertionError.class)
    public void testAddStudioInvalid3() {
        Studio studio = mock(Studio.class);
	String studioID = null;
	when(studio.getStudioID()).thenReturn(studioID);
	studiosUnderTest.addStudioBean(studio);
    }
    @Test
    public void testGetAllStudios() {
        assertSame(studios, studiosUnderTest.getAllStudios());
    }
    @Test
    public void testGetStudioById() {
        Studio studio = mock(Studio.class);
	String studioID = "001";
        String studioName = "1st Studio";
        String studioAddress = "AA 1";
	when(studio.getStudioID()).thenReturn(studioID);
        when(studio.getStudioName()).thenReturn(studioName);
        when(studio.getStudioAddress()).thenReturn(studioAddress);
	studiosUnderTest.addStudioBean(studio);
	assertSame(studiosUnderTest.getStudioById(studioID), studio);
        assertNull(studiosUnderTest.getStudioById("Other ID"));
    }
    @Test
    public void testDeleteStudio(){
        Studio studio = mock(Studio.class);
	String studioID = "001";
	when(studio.getStudioID()).thenReturn(studioID);
	studiosUnderTest.deleteStudio(studio);
	assertSame(studiosUnderTest.getStudioById(studioID), null);
    }
}
