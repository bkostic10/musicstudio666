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

//        @Test
//        void testApplicationStartup() {
//                open(BASE_URL);
//                assertTextPresent("Hello");
//                waitForPageToLoad("10000");//This is just for demonstration purposes. You usually do not need to use this.
//        }
         @Test
        void testRegistration() {
            open(BASE_URL);
		click("link=Register");
		waitForPageToLoad("30000");
		click("submit");
		//click("firstname");
		type("firstname", "a");
		type("lastname", "a");
		type("personalnumber", "a");
		type("username", "a");
		type("password", "a");
		type("password2", "a");
		click("submit");
		//click("firstname");
		type("firstname", "aaaaa");
		type("lastname", "aaaaa");
		click("submit");
		type("firstname", "Pera");
		type("lastname", "Peric");
		type("personalnumber", "123123123");
		type("username", "admin");
		type("password", "admin");
		type("password2", "admin");
		click("submit");
		waitForPageToLoad("30000");
        }


}

