<?php
declare(strict_types=1);

use PHPUnit\Framework\TestCase;

require_once __DIR__ . '/../../src/zEngine/app/models/product.m.php';

final class ProductTest extends TestCase
{
    public function testModelCanBeCreated(): void
    {
        $this->assertInstanceOf(
            ProductModel::class,
            new ProductModel()
        );
    }

	public function testProductAlias(): void
    {
		$p = new ProductModel();
		$product_name = 'Test product name';
		$p->set('product_name', $product_name);
        $this->assertEquals(
            $product_name,
            $p->getAliasUrl()
        );
    }
	
	public function testProductViewPath(): void
    {
		$p = new ProductModel();
		$product_id = 15;
		$p->set('product_id', $product_id);
        $this->assertEquals(
            'default/default/product/' . $product_id,
            $p->getViewPath()
        );
    }

}