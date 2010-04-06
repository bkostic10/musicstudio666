package org.bane8006.MusicStudio.services;

import org.apache.tapestry5.*;
import org.apache.tapestry5.hibernate.HibernateSymbols;
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor;
import org.apache.tapestry5.hibernate.HibernateTransactionDecorator;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Match;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.service.IDataStudiosService;
import org.bane8006.MusicStudio.service.IDataUserService;
import org.bane8006.MusicStudio.service.MockDataStudios;
import org.bane8006.MusicStudio.service.MockDataUser;
import org.bane8006.MusicStudio.service.hibernate.DataUserHibernate;
import org.bane8006.MusicStudio.aints.Room;
import org.bane8006.MusicStudio.aints.Studio;
import org.bane8006.MusicStudio.aints.User;


public class AppModule{

    public static void bind(ServiceBinder binder){
        binder.bind(IDataUserService.class, DataUserHibernate.class);
    }
    
    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration){        
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
        configuration.add(HibernateSymbols.EARLY_START_UP, "true");
    }

    public static void contributeHibernateEntityPackageManager(Configuration<String> configuration){
        configuration.add("org.bane8006.MusicStudio.beans");
    }

    @Match("*IDataUserService")
    public static <T> T decorateTransactionally(HibernateTransactionDecorator decorator, Class<T> serviceInterface,T delegate, String serviceId) {
        return decorator.build(serviceInterface, delegate, serviceId);
    }
    @Match("*Service")
    public static void adviseTransactions(HibernateTransactionAdvisor advisor, MethodAdviceReceiver receiver){
        advisor.addTransactionCommitAdvice(receiver);
    };

//    public static IDataUser buildIDataUser() {
//	return new MockDataUser();
//    }

    public static IDataStudiosService buildIDataStudios() {
	return new MockDataStudios();
    }

    public static User buildUser(){
        return new UserBean();
    }

    public static Room buildRoom(){
        return new RoomBean();
    }

    public static Studio buildStudio(){
        return new StudioBean();
    }

}
