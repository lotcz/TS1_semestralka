package tests;

import pageobjects.FrontPageObject;
import pageobjects.CategoryPageObject;
import pageobjects.LoginPageObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import pageobjects.CartPageObject;

/**
 * Implements PT 2
 */
public class TestCase2 extends EShopTestBase {

    @BeforeClass
    public static void setUpClass() {
        initializeDriver();
    }

    @AfterClass
    public static void tearDownClass() {
        quitDriver();
    }

    /**
     * Implements PT 2
     */
    @Test
    public void test() {
        
        // INITIALIZE (go to homepage and verify we are on the e-shop)
        FrontPageObject front_page = new FrontPageObject(this);
        front_page.open();
        assertEquals("Given URL doesn't seem to be actual e-shop front page.", front_page.main_title.getText(), "Parfumerie-hračky.cz");
        
        // 1 - select category
        String categoryName = "HRAČKY";
        front_page.clickCategoryLink(categoryName);
        
        CategoryPageObject category_page = new CategoryPageObject(this, base_url);
        assertEquals(String.format("Given URL doesn't seem to be category page for %s.", categoryName), category_page.header1.getText().toString(), categoryName);

        // 9 - sign in
        LoginPageObject login_page = new LoginPageObject(this);
        login_page.open();
        login_page.login(login, password);
        assertTrue("Could not log in.", elementExists(By.className("glyphicon-log-out")));
        
        // 8 - finish shopping
        CartPageObject cart_page = new CartPageObject(this);
        cart_page.open();
        assertFalse("Login button should not be present!", cart_page.loginButtonExists());
        assertFalse("Register button should not be present!", cart_page.registerButtonExists());
                        
    }

}
