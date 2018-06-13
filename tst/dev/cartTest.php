<?php
declare(strict_types=1);

use PHPUnit\Framework\TestCase;

require_once __DIR__ . '/../../src/zEngine/app/models/cart.m.php';
require_once __DIR__ . '/../../src/zEngine/modules/cart.php';

final class CartTest extends TestCase
{
    public function testModelCanBeCreated(): void
    {
        $this->assertInstanceOf(
            CartModel::class,
            new CartModel()
        );
    }

	public function testModuleCanBeCreated(): void
    {
		$z = new zEngine(__DIR__ . '/app/');
		$module = new cartModule($z);
        $this->assertInstanceOf(
            cartModule::class,
            $module
        );
    }

}