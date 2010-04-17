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
            type("username", "pera111");
            type("password", "pera111");
            type("password2", "pera111");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Back To The Hello Page");
            waitForPageToLoad("30000");

            type("userName", "pera111");
            type("password", "pera111");
            click("submit");
            waitForPageToLoad("30000");

            click("link=UserInfo");
            waitForPageToLoad("30000");
            click("link=Edit info");
            waitForPageToLoad("30000");

            type("firstname", "");
            type("lastname", "");
            type("personalnumber", "");
            type("username", "");
            type("oldPassword", "");
            type("password", "");
            type("password2", "");
            click("submit");

            type("firstname", "c");
            type("lastname", "c");
            type("personalnumber", "13123");
            type("username", "c");
            type("oldPassword", "c");
            type("password", "c");
            type("password2", "c");
            click("submit");

            type("firstname", "c");
            type("lastname", "c");
            type("personalnumber", "13123");
            type("username", "c");
            type("oldPassword", "c");
            type("password", "c");
            type("password2", "c");
            click("submit");

            type("firstname", "Cuca");
            type("lastname", "Cucic");
            type("personalnumber", "091237891264");
            type("username", "cuca5cuca5cuca5cuca5");
            type("oldPassword", "c");
            type("password", "cuca5cuca5cuca5cuca5");
            type("password2", "cuca5cuca5cuca5");
            click("submit");

            type("firstname", "Cuca");
            type("lastname", "Cucic");
            type("personalnumber", "091237891264");
            type("username", "cuca5");
            type("oldPassword", "c");
            type("password", "cuca5");
            type("password2", "cuc");
            click("submit");
            waitForPageToLoad("30000");
            assertTextPresent("Data invalid!!!");

            type("firstname", "Cuca");
            type("lastname", "Cucic");
            type("personalnumber", "091237891264");
            type("username", "cuca5");
            type("oldPassword", "pera111");
            type("password", "cuca5");
            type("password2", "cuca5");
            click("submit");
            waitForPageToLoad("30000");

            assertTextPresent("Info is changed");
            click("link=Back");
            waitForPageToLoad("30000");

            type("userName", "cuca5");
            type("password", "cuca5");
            click("submit");
            waitForPageToLoad("30000");

            click("link=UserInfo");
            waitForPageToLoad("30000");
            click("link=Delete Account");
            waitForPageToLoad("30000");
            click("//input[@value='Delete Account']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
        }
}

