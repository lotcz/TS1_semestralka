package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents confirmation page.
 */
public class ConfirmationPageObject extends EShopPageObject {
       
    @FindBy(id = "submit_button")
    public WebElement submit_button;
         
    public ConfirmationPageObject(SeleniumTestBase parent_test) {
        super(parent_test, "confirm");
    }
        
    public void submit() {        
        submit_button.click();
    }
        
}