@echo off

echo Starting Selenium Grid - NODE!

set q="
set node1=%cd%
set node2=\SeleniumStandaloneJar
set node=%node1%%node2%

set chrome1=%cd%
set chrome2=\Drivers\ChromeDriver\chromedriver.exe
set chromedriver=%q%%chrome1%%chrome2%%q%
echo %chromedriver%

set firefox1=%cd%
set firefox2=\Drivers\FirefoxDriver\geckodriver.exe
set firefoxdriver=%q%%firefox1%%firefox2%%q%

set ie1=%cd%
set ie2=\Drivers\IEorEdgeDriver\IEDriverServer.exe
set iedriver=%q%%ie1%%ie2%%q%

cd %node%
java -jar -Dwebdriver.chrome.driver=%chromedriver% -Dwebdriver.firefox.driver=%firefoxdriver% -Dwebdriver.ie.driver=%iedriver% selenium-server-standalone-3.8.1.jar -role node -hub http://localhost:4444/grid/register -port 5566 -browser browserName=firefox,maxInstances=2 -browser browserName=ie,maxInstances=2 -browser browserName=chrome,maxInstances=2 -maxSession 2