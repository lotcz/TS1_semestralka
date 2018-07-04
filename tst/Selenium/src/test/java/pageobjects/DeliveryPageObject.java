package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents delivery type selection page.
 */
public class DeliveryPageObject extends EShopPageObject {
       
    @FindBy(id = "submit_button")
    public WebElement submit_button;
    
    @FindBy(name = "customer_name")
    public WebElement customer_name;
    
    @FindBy(name = "customer_address_city")
    public WebElement customer_address_city;
    
    @FindBy(name = "customer_address_street")
    public WebElement customer_address_street;
    
    @FindBy(name = "customer_address_zip")
    public WebElement customer_address_zip;
    
    @FindBy(name = "customer_email")
    public WebElement customer_email;
     
    public DeliveryPageObject(SeleniumTestBase parent_test) {
        super(parent_test, "delivery");
    }
        
    public void submit(String name, String city, String street, String zip, String email) {
        customer_name.sendKeys(name);
        customer_address_city.sendKeys(city);
        customer_address_street.sendKeys(street);
        customer_address_zip.sendKeys(zip);
        if (email != null) {
            customer_email.sendKeys(email);
        }
        submit_button.click();
    }
     
    public void submit(String name, String city, String street, String zip) {
        this.submit(name, city, street, zip, null);
    }
}