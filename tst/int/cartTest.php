<?php
declare(strict_types=1);

use PHPUnit\Framework\TestCase;

require_once __DIR__ . '/../../src/zEngine/app/models/cart.m.php';
require_once __DIR__ . '/../../src/zEngine/app/models/product.m.php';
require_once __DIR__ . '/../../src/zEngine/app/models/customer.m.php';

/**
* implements CRUD tests for cart entity
*/
final class CartTest extends TestCase
{
	private $test_product_id = 18;	
	private $test_customer_id = 1;
	private $test_quantity = 5;
	
	public function testClearData(): void {
		global $z;
		$cart = new CartModel($z->core->db);
		$cart->load($this->test_product_id, $this->test_customer_id);
		if ($cart->is_loaded) {
			$cart->deleteById();	
		}	

		$cart2 = new CartModel($z->core->db);
		$cart2->load($this->test_product_id, $this->test_customer_id);
		
		$this->assertInstanceOf(
            CartModel::class,
            $cart2
        );
		
		$this->assertFalse(            
            $cart2->is_loaded
        );
	}
	  
	/**
	* @depends testClearData
	*/ 
    public function testCreate(): CartModel
    {
		global $z;
		$product = new ProductModel($z->core->db, $this->test_product_id);
		
		$this->assertInstanceOf(
            ProductModel::class,
            $product
        );
		
		$test_product_price = $product->fval('product_price');
		
		$customer = new CustomerModel($z->core->db, $this->test_customer_id);
		
		$this->assertInstanceOf(
            CustomerModel::class,
            $customer
        );
		
		$cart = new CartModel($z->core->db);		
		$cart->data['cart_product_id'] = $this->test_product_id;
		$cart->data['cart_customer_id'] = $this->test_customer_id;
		$cart->data['cart_count'] = $this->test_quantity;
		$cart->save();
		
        $this->assertInstanceOf(
            CartModel::class,
            $cart
        );
		
		return $cart;
    }

	/**
     * @depends testCreate
     */
	public function testRead(CartModel $test_cart): void
    {
		global $z;
		$cart = new CartModel($z->core->db);
		$cart->load($this->test_product_id, $this->test_customer_id);
        
		$this->assertInstanceOf(
            CartModel::class,
            $cart
        );
		
		$this->assertTrue(            
            $cart->is_loaded
        );
		
		$this->assertEquals(
			$test_cart->ival('cart_id'),
            $cart->ival('cart_id')
        );
		
		$this->assertEquals(
			$test_cart->ival('cart_count'),
            $cart->ival('cart_count')
        );
		
    }
	
	/**
     * @depends testCreate
     */
	public function testUpdate(CartModel $test_cart): void
    {
		global $z;
		$cart = new CartModel($z->core->db);
		$cart->load($this->test_product_id, $this->test_customer_id);
        
		$this->assertInstanceOf(
            CartModel::class,
            $cart
        );
		
		$this->assertTrue(            
            $cart->is_loaded
        );
		
		$this->assertEquals(
			$test_cart->ival('cart_count'),
            $cart->ival('cart_count')
        );
				
		$cart->data['cart_count'] = $this->test_quantity + 2;
		$cart->save();
		
		$cart2 = new CartModel($z->core->db);
		$cart2->load($this->test_product_id, $this->test_customer_id);
		
		$this->assertInstanceOf(
            CartModel::class,
            $cart2
        );
		
		$this->assertTrue(            
            $cart2->is_loaded
        );
		
		$this->assertEquals(
			$this->test_quantity + 2,
            $cart2->ival('cart_count')
        );
    }
	
	/**
     * @depends testCreate
     */
	public function testDeleteManually(): void
    {
		global $z;
		$cart = new CartModel($z->core->db);
		$cart->load($this->test_product_id, $this->test_customer_id);
		
		$this->assertInstanceOf(
            CartModel::class,
            $cart
        );
		
		$this->assertTrue(            
            $cart->is_loaded
        );
				
		$cart->deleteById();
		
		$cart2 = new CartModel($z->core->db);
		$cart2->load($this->test_product_id, $this->test_customer_id);
		
		$this->assertInstanceOf(
            CartModel::class,
            $cart2
        );
		
		$this->assertFalse(            
            $cart2->is_loaded
        );
    }

	/**
     * @depends testCreate
     */
	public function testDeleteByCreatingOrder(): void
    {
		global $z;
		$z->cart->emptyCart($this->test_customer_id);
				
		$cart2 = new CartModel($z->core->db);
		$cart2->load($this->test_product_id, $this->test_customer_id);
		
		$this->assertInstanceOf(
            CartModel::class,
            $cart2
        );
		
		$this->assertFalse(            
            $cart2->is_loaded
        );
    }
}