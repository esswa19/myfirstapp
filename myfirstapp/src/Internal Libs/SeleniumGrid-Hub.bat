@echo off
echo Starting Selenium Grid - Hub!

set a=%cd%
set b=\SeleniumStandaloneJar
set c=%a%%b%

echo %c%

cd %c%
java -jar selenium-server-standalone-3.8.1.jar -role hub