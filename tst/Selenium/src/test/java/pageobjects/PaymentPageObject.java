package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents payment type selection page.
 */
public class PaymentPageObject extends EShopPageObject {
       
    @FindBy(id = "submit_button")
    public WebElement submit_button;
         
    public PaymentPageObject(SeleniumTestBase parent_test) {
        super(parent_test, "payment");
    }
        
    public void submit() {        
        submit_button.click();
    }
        
}