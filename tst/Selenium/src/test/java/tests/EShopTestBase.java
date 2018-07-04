package tests;

/**
 * Base class for all e-shop tests.
 */
public class EShopTestBase extends SeleniumTestBase {
    
    public String login = "karel@zavadil.eu";
    public String password = "karel123";
        
    public EShopTestBase() {
        //base_url = "http://shop.zavadil.eu";
        //base_url = "http://google.com";
        base_url = "http://zshop.loc";
    }
        
}
