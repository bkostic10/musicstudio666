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
        void testRegistrationFailure03() {
            open(BASE_URL);
            click("link=Register");
            waitForPageToLoad("30000");
            type("firstname", "");
            type("lastname", "");
            type("personalnumber", "");
            type("username", "");
            type("password", "");
            type("password2", "");
            click("submit");
        }
        @Test
        void testRegistrationFailure01() {
            open(BASE_URL);
            click("link=Register");
            waitForPageToLoad("30000");
            type("firstname", "a");
            type("lastname", "a");
            type("personalnumber", "a");
            type("username", "a");
            type("password", "a");
            type("password2", "a");
            click("submit");
        }
        @Test
        void testRegistrationFailure02() {
            open(BASE_URL);
            click("link=Register");
            waitForPageToLoad("30000");
            type("firstname", "Pera");
            type("lastname", "Peric");
            type("personalnumber", "123123123");
            type("username", "adminadminadminadmin");
            type("password", "adminadminadminadmin");
            type("password2", "admin2");
            click("submit");
        }
        @Test
        void testLoginFailure2(){
            open(BASE_URL);
            type("userName", "");
            type("password", "");
            click("submit");
        }
        @Test
        void testLoginFailure1(){
            open(BASE_URL);
            type("userName", "admin");
            type("password", "a");
            click("submit");
            waitForPageToLoad("30000");
        }
        @Test
        void testRest(){
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
            click("link=Back To The Hello Page");
            waitForPageToLoad("30000");
            open(BASE_URL);
            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");
            click("link=UserInfo");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=About");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=Contact");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
}

