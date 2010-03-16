/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.ArrayList;
import org.bane8006.MusicStudio.beans.StudioBean;

/**
 *
 * @author Baxter
 */
public interface IDataStudios {
    public ArrayList<StudioBean> getAllStudios();
    public StudioBean getStudioByName(String name);
    public void addStudioBean(StudioBean sb);
    public void deleteStudio(StudioBean s);
}
