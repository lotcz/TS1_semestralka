/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

/**
 *
 * @author karel
 */
public class TestCase1 extends EShopTestBase {

    @BeforeClass
    public static void setUpClass() {
        initializeDriver();
    }

    @AfterClass
    public static void tearDownClass() {
        quitDriver();
    }

    /**
     * This simple test verifies whether there is actual e-shop page.
     * @return 
     */
    private boolean isActualShop() {
        try {           
            WebElement element = driver.findElement(By.className("main-title"));
            return ("Parfumerie-hračky.cz".equals(element.getText()));
        } catch (NoSuchElementException e) {
            return false;    
        }         
    }
    
    @Test
    public void test1() {
        //INITIALIZE
        goTo("");
        assertTrue("Given URL doesn't seem to be actual e-shop front page.", isActualShop());
        
        // LOGIN
        LoginPageObject login_page = new LoginPageObject(driver, getPageUrl("login"));
        login_page.open();
        login_page.login(login, password);
        assertTrue("Could not log in.", elementExists(By.className("glyphicon-log-out")));
        
    }

}
