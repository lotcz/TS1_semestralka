package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents any page in e-shop with categories menu on side.
 */
public class EShopWithCatsPageObject extends EShopPageObject {
   
    @FindBy(id="side-menu")
    public WebElement side_menu;
    	  
    public EShopWithCatsPageObject(SeleniumTestBase parent_test, String page_url) {
        super(parent_test,page_url);
    }
    
    public WebElement findCategoryLink(String categoryName){
        return side_menu.findElement(By.linkText(categoryName));
    }

    public void clickCategoryLink(String categoryName){
        findCategoryLink(categoryName).click();
    }
    
}