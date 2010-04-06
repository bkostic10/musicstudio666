/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

import java.util.Collection;
import org.bane8006.MusicStudio.aints.Studio;

/**
 *
 * @author Baxter
 */
public interface IDataStudiosService {
    public Collection<Studio> getAllStudios();
    public Studio getStudioById(String id);
    public void addStudioBean(Studio sb);
    public void deleteStudio(Studio s);
    public void load();
}
