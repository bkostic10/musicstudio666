package org.bane8006.MusicStudio.services;

import org.apache.tapestry5.*;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.bane8006.MusicStudio.beans.RoomBean;
import org.bane8006.MusicStudio.beans.StudioBean;
import org.bane8006.MusicStudio.beans.UserBean;
import org.bane8006.MusicStudio.data.IDataStudios;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.data.MockDataStudios;
import org.bane8006.MusicStudio.data.MockDataUser;
import org.bane8006.MusicStudio.service.Room;
import org.bane8006.MusicStudio.service.Studio;
import org.bane8006.MusicStudio.service.User;


public class AppModule{

    public static void bind(ServiceBinder binder){
        // binder.bind(MyServiceInterface.class, MyServiceImpl.class); 
    }
    
    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration){        
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
    }

    public static IDataUser buildIDataUser() {
	return new MockDataUser();
    }

    public static IDataStudios buildIDataStudios() {
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
