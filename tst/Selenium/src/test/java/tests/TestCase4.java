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
 * Implements PT 4
 */
public class TestCase4 extends EShopTestBase {

    @BeforeClass
    public static void setUpClass() {
        initializeDriver();
    }

    @AfterClass
    public static void tearDownClass() {
        quitDriver();
    }

    /**
     * Implements PT 4
     */
    @Test
    public void test() {
        
        float cart_price = 0;
        
        // INITIALIZE (go to homepage and verify we are on the e-shop)
        FrontPageObject front_page = new FrontPageObject(this);
        front_page.open();
        assertEquals("Given URL doesn't seem to be actual e-shop front page.", "Parfumerie-hračky.cz", front_page.main_title.getText().toString());
        
        // 1 - select category
        String category_name = "KNIHY A KALENDÁŘE";
        front_page.clickCategoryLink(category_name);
        
        CategoryPageObject category_page = new CategoryPageObject(this, base_url);
        assertEquals(String.format("Given URL doesn't seem to be category page for %s.", category_name), category_name, category_page.header1.getText().toString());
            
        // 3 - change page
        category_page.changePage(7);        
        assertEquals("Active page number does not match!", 7, category_page.getActivePage());
        
        // 7 - add item to cart
        String product_name = "Robinson Crusoe 12+";        
        category_page.buyProduct(product_name);
        cart_price += category_page.getProductPrice(product_name);
                       
        // 6 - open cart
        CartPageObject cart_page = new CartPageObject(this);
        cart_page.open();
        assertTrue("Login button should be present!", cart_page.loginButtonExists());
        assertTrue("Register button should be present!", cart_page.registerButtonExists());
        assertFalse("Order button should not be present!", cart_page.orderButtonExists());
        assertEquals("Cart total price does not match!", cart_price, cart_page.getCartTotalPrice(), 0.001);
                        
        // 8 - finish shopping        
        cart_page.register_button.click();
        DeliveryPageObject delivery_page = new DeliveryPageObject(this);        
        Double rnd = Math.random()*100;       
        int i = rnd.intValue();
        delivery_page.submit("Karel Zavadil", "Praha", "Železničářů 17", "17000", String.format("test%d@zavadil.eu",i));
                
        PaymentPageObject payment_page = new PaymentPageObject(this);
        payment_page.submit();
        
        ConfirmationPageObject confirm_page = new ConfirmationPageObject(this);
        confirm_page.submit();
        
        OrderDetailPageObject order_page = new OrderDetailPageObject(this);
        assertEquals("Order total price does not match!", cart_price, order_page.getOrderSubtotalPrice(), 0.001);
        
    }

}
