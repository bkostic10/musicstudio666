/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bane8006.MusicStudio.Booking;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.hibernate.LockMode;
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
        List all = session.createQuery("from StudioBean").list();
        return all;
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
        for(Iterator<Room> it = s.getAllRooms().iterator();it.hasNext();){
            Room r = it.next();
            for(Iterator<Booking> it2 = r.getAllBookings().iterator();it2.hasNext();){
                Booking b = it2.next();
                it2.remove();
                session.delete(b);
            }
            it.remove();
            session.delete(r);
        }
        session.delete(s);
    }

    @Override
    public void updateStudio(Studio s) {
        session.update(s);
    }
    @Override
    public void deleteRoom(Studio s,Room room){
        long a = s.getIdStudio();
        s = (Studio) session.load(StudioBean.class, a);
        for(Iterator<Room> it = s.getAllRooms().iterator();it.hasNext();){
            Room r = it.next();
            if(r.getIdRoom()==room.getIdRoom()){
                for(Iterator<Booking> it2 = r.getAllBookings().iterator();it2.hasNext();){
                    Booking b = it2.next();
                    it2.remove();
                    session.delete(b);
                }
                it.remove();
                session.delete(r);
            }
        }
    }
    @Override
    public void deleteBooking(Studio s,Room room,Booking b){
        long a = s.getIdStudio();
        s = (Studio) session.load(StudioBean.class, a);
        for(Iterator<Room> it = s.getAllRooms().iterator();it.hasNext();){
            Room r = it.next();
            if(r.getIdRoom()==room.getIdRoom()){
                for(Iterator<Booking> it2 = r.getAllBookings().iterator();it2.hasNext();){
                    Booking book = it2.next();
                    if(book.getIdBooking()==b.getIdBooking()){
                        it2.remove();
                        session.delete(b);
                    }

                }
            }
        }
    }

    @Override
    public void lockStudio(Studio s) {
        session.lock(s, LockMode.NONE);
    }
}
