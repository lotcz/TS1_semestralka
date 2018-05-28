<?php
declare(strict_types=1);

use PHPUnit\Framework\TestCase;

require_once __DIR__ . '/../../src/zEngine/app/models/order.m.php';

final class OrderTest extends TestCase
{
    public function testModelCanBeCreated(): void
    {
        $this->assertInstanceOf(
            OrderModel::class,
            new OrderModel()
        );
    }

}