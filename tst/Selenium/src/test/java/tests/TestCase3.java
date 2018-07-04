package tests;

import pageobjects.FrontPageObject;
import pageobjects.CategoryPageObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import pageobjects.CartPageObject;
import pageobjects.ConfirmationPageObject;
import pageobjects.DeliveryPageObject;
import pageobjects.LoginPageObject;
import pageobjects.OrderDetailPageObject;
import pageobjects.PaymentPageObject;

/**
 * Implements PT 3
 */
public class TestCase3 extends EShopTestBase {

    @BeforeClass
    public static void setUpClass() {
        initializeDriver();
    }

    @AfterClass
    public static void tearDownClass() {
        quitDriver();
    }

    /**
     * Implements PT 3
     */
    @Test
    public void test() {
        
        float cart_price = 0;
        
        // INITIALIZE (go to homepage and verify we are on the e-shop)
        FrontPageObject front_page = new FrontPageObject(this);
        front_page.open();
        assertEquals("Given URL doesn't seem to be actual e-shop front page.", "Parfumerie-hračky.cz", front_page.main_title.getText().toString());
        
        // 1 - select category
        String category_name = "HRAČKY";
        front_page.clickCategoryLink(category_name);
        
        CategoryPageObject category_page = new CategoryPageObject(this, base_url);
        assertEquals(String.format("Given URL doesn't seem to be category page for %s.", category_name), category_name, category_page.header1.getText().toString());
            
        // 3 - change page
        category_page.changePage(3);        
        assertEquals("Active page number does not match!", 3, category_page.getActivePage());
        
        // 7 - add item to cart
        String product_name = "Sada na otisk ručičky";        
        category_page.buyProduct(product_name);
        cart_price += category_page.getProductPrice(product_name);
        
        // 3 - change page
        waitForElement(By.linkText("7"));
        category_page.changePage(7);        
        assertEquals("Active page number does not match!", 7, category_page.getActivePage());
        
        // 7 - add item to cart
        product_name = "Lucky Puppies sáček";        
        category_page.buyProduct(product_name);
        cart_price += category_page.getProductPrice(product_name);
        
        // 2 - add item to cart
        product_name = "Karty Mariáš Jednohlavé";        
        category_page.buyProduct(product_name);
        cart_price += category_page.getProductPrice(product_name);
        
        // 5 - search for another product
        
        // 1 - select category
        String category_name_2 = "KOSMETIKA";
        waitForElement(By.linkText(category_name_2));
        category_page.clickCategoryLink(category_name_2);
        
        CategoryPageObject category_page_2 = new CategoryPageObject(this, base_url);
        assertEquals(String.format("Given URL doesn't seem to be category page for %s.", category_name_2), category_name_2, category_page_2.header1.getText().toString());
        
        // 2 - add item to cart
        product_name = "Nikis fashion Sukýnka mix";        
        category_page.buyProduct(product_name);
        cart_price += category_page.getProductPrice(product_name);
        
        // 5 - search for another product
        
        // 1 - select category
        String category_name_3 = "DROGERIE";
        waitForElement(By.linkText(category_name_3));
        category_page.clickCategoryLink(category_name_3);
        
        CategoryPageObject category_page_3 = new CategoryPageObject(this, base_url);
        assertEquals(String.format("Given URL doesn't seem to be category page for %s.", category_name_3), category_name_3, category_page_3.header1.getText().toString());
        
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
        assertTrue("Order button should be present!", cart_page.orderButtonExists());
        assertEquals("Cart total price does not match!", cart_price, cart_page.getCartTotalPrice(), 0.001);
        
        cart_page.order_button.click();
        
        DeliveryPageObject delivery_page = new DeliveryPageObject(this);        
        delivery_page.submit_button.click();
        
        PaymentPageObject payment_page = new PaymentPageObject(this);
        payment_page.submit();
        
        ConfirmationPageObject confirm_page = new ConfirmationPageObject(this);
        confirm_page.submit();
        
        OrderDetailPageObject order_page = new OrderDetailPageObject(this);
        assertEquals("Order total price does not match!", cart_price, order_page.getOrderSubtotalPrice(), 0.001);
        
    }

}
