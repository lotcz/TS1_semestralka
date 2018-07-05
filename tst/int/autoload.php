<?php

	require_once __DIR__ . '/../../src/zEngine/zengine.php';
	require_once __DIR__ . '/../../src/zEngine/classes/model.php';
	require_once __DIR__ . '/../../src/zEngine/modules/mysql.php';
	require_once __DIR__ . '/../../src/zEngine/modules/cart.php';
	
	global $z;
	
	$z = new zEngine(__DIR__ . '/app/');
	$z->enableModule('mysql');
	$z->enableModule('cart');