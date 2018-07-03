package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents any page in e-shop with product list.
 */
public class EShopWithProductsPageObject extends EShopWithCatsPageObject {
   
    @FindBy(id="products-container")
    public WebElement products;
    
    @FindBy(className="pagination")
    public WebElement pagination;
    
    @FindBy(className="continue-shopping-button")
    public WebElement continue_button;
    	  
    public EShopWithProductsPageObject(SeleniumTestBase parent_test, String page_url) {
        super(parent_test, page_url);
    }
    
    public WebElement findProductLink(String productName){
        return products.findElement(By.linkText(productName));
    }

    public WebElement findProductContainer(String productName){
        return findProductLink(productName).findElement(By.xpath("../../.."));
    }
    
    public WebElement findProductBuyButton(String productName){
        return findProductContainer(productName).findElement(By.className("add-to-cart-button"));
    }
    
    public void buyProduct(String productName){
        findProductBuyButton(productName).click();
        test.waitForElement(By.className("continue-shopping-button"));
        continue_button.click();
    }
    
    public float getProductPrice(String productName){
        WebElement product_container = findProductContainer(productName);
        WebElement price_container = product_container.findElement(By.className("price"));
        return Float.parseFloat(extractNumberFromString(price_container.getText()));        
    }
    
    public void changePage(int pageNumber) {
        pagination.findElement(By.linkText(Integer.toString(pageNumber))).click();
    }
    
    public int getActivePage() {
        return Integer.parseInt(pagination.findElement(By.className("active")).findElement(By.tagName("a")).getText());
    }
    
}