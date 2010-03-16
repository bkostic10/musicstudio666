/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import java.util.List;
import org.bane8006.MusicStudio.beans.StudioBean;

/**
 *
 * @author Baxter
 */
public class MockDataStudios implements IDataStudios{

    private static List<StudioBean>studios = new ArrayList<StudioBean>();

    public MockDataStudios() {
        addStudioBean(new StudioBean("001","1st Studio","Michael Jordan Street 23,11000 Belgrade"));
    }



    public ArrayList<StudioBean> getAllStudios() {
        return (ArrayList<StudioBean>) studios;
    }

    public StudioBean getStudioByName(String name) {
        for(StudioBean sb:getAllStudios()){
            if(sb.getStudioName().equals(name))
                return sb;
        }
        return null;
    }

    public void addStudioBean(StudioBean sb) {
        if(!getAllStudios().contains(sb)){
            studios.add(sb);
        }
        else System.out.println("Studio exists!");
    }
    public void deleteStudio(StudioBean s){
        studios.remove(s);
    }
}
