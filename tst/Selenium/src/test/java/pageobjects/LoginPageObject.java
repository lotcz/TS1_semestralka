package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.SeleniumTestBase;

/**
 * Represents page with login dialog
 */
public class LoginPageObject extends EShopPageObject {
   
    @FindBy(name="email")
    public WebElement login_input;
    
    @FindBy(name="password")
    public WebElement password_input;
    
    @FindBy(className = "btn-success")
    public WebElement submit_button;
	  
    public LoginPageObject(SeleniumTestBase parent_test) {
        super(parent_test, "login");
    }
    
    public void setUserName(String strUserName){
        login_input.sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        password_input.sendKeys(strPassword);
    }

    public void clickLogin(){
        submit_button.click();
    }

    public void login(String login, String password) {
        setUserName(login);
        setPassword(password);
        clickLogin();
    }
    
}