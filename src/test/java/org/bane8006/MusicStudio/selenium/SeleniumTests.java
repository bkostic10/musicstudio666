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
        void testRegistrationFailure1() {
            open(BASE_URL);
            waitForPageToLoad("30000");
            click("link=Register");
            waitForPageToLoad("30000");
            type("firstname", "");
            type("lastname", "");
            type("personalnumber", "");
            type("username", "");
            type("password", "");
            type("password2", "");
            click("submit");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testRegistrationFailure2() {
            open(BASE_URL);
            waitForPageToLoad("30000");
            click("link=Register");
            waitForPageToLoad("30000");
            type("firstname", "a");
            type("lastname", "a");
            type("personalnumber", "a");
            type("username", "a");
            type("password", "a");
            type("password2", "a");
            click("submit");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testRegistrationFailure3() {
            open(BASE_URL);
            waitForPageToLoad("30000");
            click("link=Register");
            waitForPageToLoad("30000");
            type("firstname", "Pera");
            type("lastname", "Peric");
            type("personalnumber", "123123123");
            type("username", "adminadminadminadmin");
            type("password", "adminadminadminadmin");
            type("password2", "admin2");
            click("submit");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testRegistrationSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testLoginFailure1(){
            open(BASE_URL);
            waitForPageToLoad("30000");
            type("userName", "");
            type("password", "");
            click("submit");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testLoginFailure2(){
            open(BASE_URL);
            waitForPageToLoad("30000");
            type("userName", "admin");
            type("password", "a");
            click("submit");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testLoginSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testAddStudioFailure(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "");
            type("textfield_0", "");
            type("textfield_1", "");
            click("//input[@value='Submit']");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testAddStudioFailure2(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testAddStudioSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testSeeStudioInfoSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");

        }
        @Test
        void testAddRoomFailure(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");

            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=Add Room");
            waitForPageToLoad("30000");
            type("textfield", "");
            type("textfield_0", "");
            click("//input[@value='Submit']");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testAddRoomFailure2(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");

            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=Add Room");
            waitForPageToLoad("30000");
            type("textfield", "001002");
            type("textfield_0", "1S - 2nd Room");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");

            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=Add Room");
            waitForPageToLoad("30000");
            type("textfield", "001002");
            type("textfield_0", "1S - 2nd Room");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testAddRoomSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");

            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=Add Room");
            waitForPageToLoad("30000");
            type("textfield", "001001");
            type("textfield_0", "1S - 1st Room");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testSeeRoomInfoSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");

            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=Add Room");
            waitForPageToLoad("30000");
            type("textfield", "001001");
            type("textfield_0", "1S - 1st Room");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=See the rooms:");
            waitForPageToLoad("30000");
            click("link=1S - 1st Room");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testChangeUserInfoFailure(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testSeeUserInfoSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testChangeUserInfoSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("firstname", "Cuca");
            type("lastname", "Cucic");
            type("personalnumber", "091237891264");
            type("username", "cuca5");
            type("oldPassword", "pera111");
            type("password", "cuca5");
            type("password2", "cuc");
            click("submit");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testDeleteUserSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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
            click("link=Delete Account");
            waitForPageToLoad("30000");
            click("//input[@value='Delete Account']");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testDeleteStudioSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=Delete Studio");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testDeleteRoomSuccess(){
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");

            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=Add Room");
            waitForPageToLoad("30000");
            type("textfield", "001001");
            type("textfield_0", "1S - 1st Room");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=See the rooms:");
            waitForPageToLoad("30000");
            click("link=1S - 1st Room");
            waitForPageToLoad("30000");
            click("link=Delete Room");
            waitForPageToLoad("30000");
            click("link=Back To The Studio Details");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
        @Test
        void testBookRoom() {
            open(BASE_URL);
            waitForPageToLoad("30000");
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

            type("userName", "admin");
            type("password", "admin");
            click("submit");
            waitForPageToLoad("30000");

            click("link=Add Studio");
            waitForPageToLoad("30000");
            click("//input[@value='Submit']");
            type("textfield", "001");
            type("textfield_0", "1st Studio");
            type("textfield_1", "AA 1");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");

            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=Add Room");
            waitForPageToLoad("30000");
            type("textfield", "001001");
            type("textfield_0", "1S - 1st Room");
            click("//input[@value='Submit']");
            waitForPageToLoad("30000");
            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1st Studio");
            waitForPageToLoad("30000");
            click("link=See the rooms:");
            waitForPageToLoad("30000");
            click("link=1S - 1st Room");
            waitForPageToLoad("30000");

            assertTextPresent("Room Name:");
            assertTextPresent("Room Type:");
            assertTextPresent("Description:");
            click("datefield-trigger");
            click("//form[@id='bookRoomForm']/div[2]/div/div[3]/table/tbody/tr/td[1]/button");
            click("submit");
            waitForPageToLoad("30000");

            assertTextPresent("Room Name:");
            assertTextPresent("Room Type:");
            assertTextPresent("Description:");

            click("link=Back");
            waitForPageToLoad("30000");
            click("link=1S - 1st Room");
            waitForPageToLoad("30000");
            assertTextPresent("Room Name:");
            assertTextPresent("Room Type:");
            assertTextPresent("Description:");
            
            click("datefield-trigger");
            click("//form[@id='bookRoomForm']/div[2]/div/div[3]/table/tbody/tr/td[1]/button");
            click("submit");
            waitForPageToLoad("30000");
            assertTextPresent("Room Name:");
            assertTextPresent("Room Type:");
            assertTextPresent("Description:");
            click("link=LogOut");
            waitForPageToLoad("30000");
        }
}

