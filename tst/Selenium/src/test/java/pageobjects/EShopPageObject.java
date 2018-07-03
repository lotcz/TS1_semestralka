package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents any page in e-shop.
  */
public class EShopPageObject extends PageObjectBase {
   
    @FindBy(className = "main-title")
    public WebElement main_title;
  	  
    @FindBy(tagName = "h1")
    public WebElement header1;
    
    @FindBy(className = "cart-total-price")
    public WebElement cart_total_price;
    
    public EShopPageObject(SeleniumTestBase parent_test, String page_url) {
        super(parent_test, page_url);
    }
    
    public float getCartTotalPrice() {
        return Float.parseFloat(extractNumberFromString(cart_total_price.getText()));
    }
    
}