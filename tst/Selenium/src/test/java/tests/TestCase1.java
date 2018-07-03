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
import pageobjects.OrderDetailPageObject;
import pageobjects.PaymentPageObject;

/**
 * Implements PT 1
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
     * Implements PT 1
     */
    @Test
    public void test() {
        
        // INITIALIZE (go to homepage and verify we are on the e-shop)
        FrontPageObject front_page = new FrontPageObject(this);
        front_page.open();
        assertEquals("Given URL doesn't seem to be actual e-shop front page.", "Parfumerie-hračky.cz", front_page.main_title.getText().toString());
        
        // 1 - select category
        String category_name = "HRAČKY";
        front_page.clickCategoryLink(category_name);
        
        CategoryPageObject category_page = new CategoryPageObject(this, base_url);
        assertEquals(String.format("Given URL doesn't seem to be category page for %s.", category_name), category_name, category_page.header1.getText().toString());

        // 2 - add item to cart
        String product_name = "Nočník Míša";
        float product_price = category_page.getProductPrice(product_name);
        category_page.buyProduct(product_name);    
        
        // 5 - search for another product
        
        // 1 - select category
        String category_name_2 = "DROGERIE";
        waitForElement(By.linkText(category_name_2));
        category_page.clickCategoryLink(category_name_2);
        
        CategoryPageObject category_page_2 = new CategoryPageObject(this, base_url);
        assertEquals(String.format("Given URL doesn't seem to be category page for %s.", category_name_2), category_name_2, category_page_2.header1.getText().toString());

        // 3 - change page
        category_page.changePage(3);        
        assertEquals("Active page number does not match!", 3, category_page.getActivePage());
        
        // 4 - select different category
        
        // 1 - select category
        String category_name_3 = "BABY PROGRAM";
        category_page.clickCategoryLink(category_name_3);
        
        CategoryPageObject category_page_3 = new CategoryPageObject(this, base_url);
        assertEquals(String.format("Given URL doesn't seem to be category page for %s.", category_name_3), category_name_3, category_page_3.header1.getText().toString());

        // 6 - open cart
        CartPageObject cart_page = new CartPageObject(this);
        cart_page.open();
        assertTrue("Login button should be present!", cart_page.loginButtonExists());
        assertTrue("Register button should be present!", cart_page.registerButtonExists());
        assertEquals("Cart total price does not match!", product_price, cart_page.getCartTotalPrice(), 0.001);

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
        assertEquals("Order total price does not match!", product_price, order_page.getOrderSubtotalPrice(), 0.001);

        
    }

}
