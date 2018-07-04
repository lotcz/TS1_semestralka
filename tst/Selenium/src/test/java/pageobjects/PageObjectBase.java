package pageobjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.NoSuchElementException;
import tests.SeleniumTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Base for all page objects.
 * 
 * Can represent any page.
 */
public class PageObjectBase {
    
    protected String relative_url;
    
    protected SeleniumTestBase test;
    
    public PageObjectBase(SeleniumTestBase parent_test, String page_url) {
        relative_url = page_url;
        test = parent_test;
	PageFactory.initElements(test.driver, this);        
    }
    
    public void open() {
        test.driver.get(test.getPageUrl(relative_url));
    }

    public boolean elementExists(WebElement we) {
        try {
            we.isDisplayed();
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }
    
    public static String extractNumberFromString(String str) {        
        Pattern p = Pattern.compile("[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return m.group().replace(" ", "");
        }
        return "";
    }
    
}
