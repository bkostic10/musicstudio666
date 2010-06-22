package org.bane8006.MusicStudio.service.spring_hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.bane8006.MusicStudio.Booking;
import org.bane8006.MusicStudio.Room;
import org.bane8006.MusicStudio.Studio;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class DataStudioDAO implements IDataStudiosService{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Transactional
	public Studio addStudioBean(Studio sb) {
		// TODO Auto-generated method stub
		Long id = (Long) sessionFactory.getCurrentSession().save(sb);
		return (Studio)sessionFactory.getCurrentSession().get(StudioBean.class, id); 
	}

	@Transactional
	public void deleteBooking(Studio s, Room room, Booking b) {
		// TODO Auto-generated method stub
        long a = s.getIdStudio();
        s = (Studio) sessionFactory.getCurrentSession().load(StudioBean.class, a);
        for(Iterator<Room> it = s.getAllRooms().iterator();it.hasNext();){
            Room r = it.next();
            if(r.getIdRoom()==room.getIdRoom()){
                for(Iterator<Booking> it2 = r.getAllBookings().iterator();it2.hasNext();){
                    Booking book = it2.next();
                    if(book.getIdBooking()==b.getIdBooking()){
                        it2.remove();
                        sessionFactory.getCurrentSession().delete(b);
                    }

                }
            }
        }
		
	}

	@Transactional
	public void deleteRoom(Studio s, Room room) {
		// TODO Auto-generated method stub
		long a = s.getIdStudio();
        s = (Studio) sessionFactory.getCurrentSession().load(StudioBean.class, a);
        for(Iterator<Room> it = s.getAllRooms().iterator();it.hasNext();){
            Room r = it.next();
            if(r.getIdRoom()==room.getIdRoom()){
                for(Iterator<Booking> it2 = r.getAllBookings().iterator();it2.hasNext();){
                    Booking b = it2.next();
                    it2.remove();
                    sessionFactory.getCurrentSession().delete(b);
                }
                it.remove();
                sessionFactory.getCurrentSession().delete(r);
            }
        }
	}

	@Transactional
	public void deleteStudio(Studio s) {
		// TODO Auto-generated method stub
		long a = s.getIdStudio();
        s = (Studio) sessionFactory.getCurrentSession().load(StudioBean.class, a);
        for(Iterator<Room> it = s.getAllRooms().iterator();it.hasNext();){
            Room r = it.next();
            for(Iterator<Booking> it2 = r.getAllBookings().iterator();it2.hasNext();){
                Booking b = it2.next();
                it2.remove();
                sessionFactory.getCurrentSession().delete(b);
            }
            it.remove();
            sessionFactory.getCurrentSession().delete(r);
        }
        sessionFactory.getCurrentSession().delete(s);
	}

	@Transactional
	public Collection<Studio> getAllStudios() {
		// TODO Auto-generated method stub
		List all = sessionFactory.getCurrentSession().createQuery("from StudioBean").list();
        return all;
	}

	@Transactional
	public Studio getStudioById(Serializable id) {
		// TODO Auto-generated method stub
		return (Studio) sessionFactory.getCurrentSession().get(StudioBean.class, id);
	}

	@Transactional
	public void updateStudio(Studio s) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(s);
	}

	
	
}
