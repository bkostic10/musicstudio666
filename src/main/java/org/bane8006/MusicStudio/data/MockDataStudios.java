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

    private List<StudioBean>studios = new ArrayList<StudioBean>();

    public MockDataStudios() {
        addStudioBean(new StudioBean("001","Prvi","AA 1",4,2));
        addStudioBean(new StudioBean("001","Drugi","AA 2",3,1));
        addStudioBean(new StudioBean("003","Treci","AA 3",3,0));
    }



    public ArrayList<StudioBean> getAllStudios() {
        return (ArrayList<StudioBean>) studios;
    }

    public StudioBean getStudioByName(String name) {
        for(StudioBean sb:studios){
            if(sb.getStudioName().equals(name))
                return sb;
        }
        return null;
    }

    public void addStudioBean(StudioBean sb) {
        studios.add(sb);
    }





    

}
