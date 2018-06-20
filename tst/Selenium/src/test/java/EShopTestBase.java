/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karel
 */
public class EShopTestBase extends SeleniumTestBase {
    
    public String login = "karel@zavadil.eu";
    public String password = "karel123";
        
    public EShopTestBase() {
        base_url = "http://shop.zavadil.eu";
        //base_url = "http://google.com";
        //base_url = "http://zshop.loc";
    }
}
