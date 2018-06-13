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
        assertTrue(isActualShop());
        
        // LOGIN
        goTo("login");
        driver.findElement(By.name("email")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElementByCssSelector("input.btn-success").click();
        
    }

}
