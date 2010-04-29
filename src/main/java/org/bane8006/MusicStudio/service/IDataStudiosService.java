/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

import java.io.Serializable;
import java.util.Collection;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;

/**
 *
 * @author Baxter
 */
public interface IDataStudiosService {
    public Collection<Studio> getAllStudios();
    public Studio getStudioById(Serializable id);
    @CommitAfter
    public Studio addStudioBean(Studio sb);
    @CommitAfter
    public void deleteStudio(Studio s);
    //public void load();

}
