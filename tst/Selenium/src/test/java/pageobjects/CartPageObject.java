package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents cart page.
 */
public class CartPageObject extends EShopPageObject {
       
    @FindBy(className = "login-button")
    public WebElement login_button;
    
    @FindBy(className = "order-register-button")
    public WebElement register_button;
    
    @FindBy(className = "order-button")
    public WebElement order_button;
	  
    public CartPageObject(SeleniumTestBase parent_test) {
        super(parent_test, "cart");
    }
    
    public boolean loginButtonExists() {
        return elementExists(login_button);
    }
    
    public boolean registerButtonExists() {
        return elementExists(register_button);
    }
    
    public boolean orderButtonExists() {
        return elementExists(order_button);
    }
    
    public void clickLogin(){
        login_button.click();
    }
    
    
}