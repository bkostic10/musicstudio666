/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.beans;

import org.bane8006.MusicStudio.service.Studio;


/**
 *
 * @author Baxter
 */
public class StudioBean implements Studio{
    private String studioID;
    private String studioName;
    private String studioAddress;
    private int numberOfJRooms;
    private int numberOfRRooms;

    


    public StudioBean() {
    }

    public StudioBean(String studioID, String studioName, String studioAddress, int numberOfJRooms, int numberOfRRooms) {
        this.studioID = studioID;
        this.studioName = studioName;
        this.studioAddress = studioAddress;
        this.numberOfJRooms = numberOfJRooms;
        this.numberOfRRooms = numberOfRRooms;
    }

    public int getNumberOfJRooms() {
        return numberOfJRooms;
    }

    public void setNumberOfJRooms(int numberOfJRooms) {
        this.numberOfJRooms = numberOfJRooms;
    }

    public int getNumberOfRRooms() {
        return numberOfRRooms;
    }

    public void setNumberOfRRooms(int numberOfRRooms) {
        this.numberOfRRooms = numberOfRRooms;
    }

    public int getNumberOfRooms() {
        return getNumberOfRRooms()+getNumberOfJRooms();
    }

    public String getStudioAddress() {
        return studioAddress;
    }

    public void setStudioAddress(String studioAddress) {
        this.studioAddress = studioAddress;
    }

    public String getStudioID() {
        return studioID;
    }

    public void setStudioID(String studioID) {
        this.studioID = studioID;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }
}
