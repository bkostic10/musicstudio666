/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.service;

/**
 *
 * @author Baxter
 */
public interface Authentication {
    
    public User authenticate(String userName,String password);
}
