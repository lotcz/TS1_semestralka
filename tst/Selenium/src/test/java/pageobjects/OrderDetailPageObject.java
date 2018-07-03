package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents order detail page.
 */
public class OrderDetailPageObject extends EShopPageObject {
       
    @FindBy(id = "order_subtotal")
    public WebElement subtotal;
         
    public OrderDetailPageObject(SeleniumTestBase parent_test) {
        super(parent_test, "order");
    }
        
    public float getOrderSubtotalPrice() {
        return Float.parseFloat(extractNumberFromString(subtotal.getText()));
    }
}