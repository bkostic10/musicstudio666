/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.data;

import java.util.Collection;
import org.bane8006.MusicStudio.service.Studio;

/**
 *
 * @author Baxter
 */
public interface IDataStudios {
    public Collection<Studio> getAllStudios();
    public Studio getStudioById(String id);
    public void addStudioBean(Studio sb);
    public void deleteStudio(Studio s);
    public void load();
}
