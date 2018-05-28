<?php
declare(strict_types=1);

use PHPUnit\Framework\TestCase;

final class zEngineTest extends TestCase
{
    public function testParseInt(): void
    {
		$this->assertNull(
            z::parseInt(null)
        );
		
        $this->assertEquals(
			0,
            z::parseInt('Hello')
        );
		
		$this->assertEquals(
			15,
            z::parseInt('15')
        );
    }

	public function testParseFloat(): void
    {
		$this->assertNull(
            z::parseFloat(null)
        );
		
        $this->assertEquals(
			0,
            z::parseFloat('Hello')
        );
		
		$this->assertEquals(
			15.55,
            z::parseFloat('15.55')
        );
    }
	
	public function testSafeDivide(): void
    {
        $this->assertEquals(
			2,
            z::safeDivide(4, 2)
        );
		
		$this->assertEquals(
			0,
            z::safeDivide(4, 0)
        );
    }

}