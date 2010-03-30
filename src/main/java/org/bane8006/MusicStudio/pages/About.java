package org.bane8006.MusicStudio.pages;

import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.data.IDataUser;
import org.bane8006.MusicStudio.service.User;

public class About
{
    @Inject
    private IDataUser users;



    @Property
    private User user;
    
    public long getCurrentPersonId() {
        return User.class.cast(user).getId();
    }
    public List<User> getAllUsers(){
        return users.getAllUsers();
    }
}
