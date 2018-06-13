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
    
    public String login = "karel";
    public String password = "karel123";
        
    public EShopTestBase() {
        url = "http://shop.zavadil.eu";
    }
}
