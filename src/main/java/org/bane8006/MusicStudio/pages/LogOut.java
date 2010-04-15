package org.bane8006.MusicStudio.pages;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.bane8006.MusicStudio.service.ILoggedUser;

public class LogOut
{
    @Inject
    private ILoggedUser lu;

    Object onActivate()
    {
        lu.remove();
        return Index.class;
    }
}
