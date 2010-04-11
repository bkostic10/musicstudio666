/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bane8006.MusicStudio.selenium;

import org.apache.tapestry5.test.AbstractIntegrationTestSuite;
import org.testng.annotations.Test;

/**
 *
 * @author Baxter
 */
public class SeleniumTests extends AbstractIntegrationTestSuite {

        @Test
        void testApplicationStartup() {
            open(BASE_URL);
            waitForPageToLoad("30000");
        }
        @Test
        void testRegistrationFailure() {
            click("link=Register");
            waitForPageToLoad("30000");
            type("firstname", "");
            type("lastname", "");
            type("personalnumber", "");
            type("username", "");
            type("password", "");
            type("password2", "");
            click("submit");
            type("firstname", "a");
            type("lastname", "a");
            type("personalnumber", "a");
            type("username", "a");
            type("password", "a");
            type("password2", "a");
            click("submit");
            type("firstname", "Pera");
            type("lastname", "Peric");
            type("personalnumber", "123123123");
            type("username", "admin");
            type("password", "admin");
            type("password2", "admin2");
            click("submit");
            waitForPageToLoad("30000");
        }
        @Test
        void testRegistrationSucces() {
            open(BASE_URL);
            click("link=Register");
            waitForPageToLoad("30000");
            type("firstname", "Pera");
            type("lastname", "Peric");
            type("personalnumber", "123123123");
            type("username", "admin");
            type("password", "admin");
            type("password2", "admin");
            click("submit");
            waitForPageToLoad("30000");
        }
        @Test
        void testLoginSucces() {
            open(BASE_URL);
            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");
        }

}

