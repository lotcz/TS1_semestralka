<?php
declare(strict_types=1);

use PHPUnit\Framework\TestCase;

require_once __DIR__ . '/../../src/zEngine/app/models/cart.m.php';
require_once __DIR__ . '/../../src/zEngine/app/models/product.m.php';
require_once __DIR__ . '/../../src/zEngine/app/models/customer.m.php';

final class CartIntegrationTest extends TestCase
{

	/**
	* implements INT 1 - integration test data lifecycle of cart entity
	*/
	public function testCartLifecycle1(): void {
		$test = new CartTest();
		$test->testClearData();
		$cart = $test->testCreate();
		$test->testRead($cart);
		$test->testUpdate($cart);
		$test->testDeleteByCreatingOrder();
	}
	  
	/**
	* implements INT 2 - integration test data lifecycle of cart entity
	*/
	public function testCartLifecycle2(): void {
		$test = new CartTest();
		$test->testClearData();
		$cart = $test->testCreate();
		$test->testRead($cart);		
		$test->testDeleteManually();		
	}
}