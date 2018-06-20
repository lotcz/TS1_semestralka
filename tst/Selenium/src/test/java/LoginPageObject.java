/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author karel
 */
public class LoginPageObject extends PageObjectBase {
   
    @FindBy(name="email")
    public WebElement login_input;
    
    @FindBy(name="password")
    public WebElement password_input;
    
    @FindBy(className = "btn-success")
    public WebElement submit_button;
	  
    public LoginPageObject(WebDriver selenium_driver, String base_url) {
        super(selenium_driver,base_url);
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