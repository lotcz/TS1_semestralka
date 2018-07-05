rem path to PHP executable
set phpPath=C:\xampp7.1\php\php.exe

rem path to phpUnit phar
set phpUnitPath=C:\develop\phpUnit\phpunit-7.1.5.phar

rem path to directory with tests
set testsPath=C:\develop\TS1\TS1_semestralka\tst\int

%phpPath% %phpUnitPath% --bootstrap %testsPath%\autoload.php --testdox %testsPath%