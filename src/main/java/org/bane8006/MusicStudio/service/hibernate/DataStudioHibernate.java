/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service.hibernate;

import java.io.Serializable;
import java.util.Collection;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Baxter
 */
public class DataStudioHibernate implements IDataStudiosService{
    
    private final Session session;

    public DataStudioHibernate(Session session) {
        this.session = session;
    }

    @Override
    public Collection<Studio> getAllStudios() {
        Criteria criteria = session.createCriteria(StudioBean.class);
        return criteria.list();
    }

    @Override
    public Studio getStudioById(Serializable id) {
        return (Studio) session.get(StudioBean.class, id);
    }

    @Override
    public Studio addStudioBean(Studio sb) {
        return (Studio)session.get(StudioBean.class, session.save(sb));
    }

    @Override
    public void deleteStudio(Studio s) {
        long a = s.getIdStudio();
        s = (Studio) session.load(StudioBean.class, a);
        session.delete(s);
    }
}
