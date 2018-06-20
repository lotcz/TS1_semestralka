
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karel
 */
public class PageObjectBase {
    
    protected String url;
    
    protected WebDriver driver;
    
    public PageObjectBase(WebDriver selenium_driver, String base_url) {
        url = base_url;
        driver = selenium_driver;
	PageFactory.initElements(driver, this);
    }
    
    public void open() {
        driver.get(url);
    }

}
