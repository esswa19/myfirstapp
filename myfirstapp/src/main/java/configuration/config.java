package configuration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.readPropfile;

import java.net.MalformedURLException;
import java.net.URL;

public class config {

    public WebDriver driver = null;
    public void startDriver() {

        readPropfile readProperty = new readPropfile();

        //System.out.println("sys path ="+System.getProperty("user.dir"));
        readProperty.readPropData(System.getProperty("user.dir") + "//src//main//resources//propfile.properties");

        // Value takes from prop.properties file
        URL execute = null;
        Capabilities capabilities = null;

        try {
            execute = new URL(readProperty.getPropValue("host") + ":" + readProperty.getPropValue("port") + "//wd//hub");
            System.out.println("Execute = "+ execute);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (readProperty.getPropValue("remoteExe").equalsIgnoreCase("Yes")) {
            if (readProperty.getPropValue("browser").equalsIgnoreCase("Chrome")) {
                capabilities = DesiredCapabilities.chrome();
            } else if (readProperty.getPropValue("browser").equalsIgnoreCase("Firefox")) {
                capabilities = DesiredCapabilities.firefox();
            } else if (readProperty.getPropValue("browser").equalsIgnoreCase("IE")) {
                capabilities = DesiredCapabilities.internetExplorer();
            } else {
                System.out.println("Enter the Browser");
            }

            driver = new RemoteWebDriver(execute, capabilities);

        } else {
            if (readProperty.getPropValue("browser").equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//Internal Libs//Drivers//ChromeDriver//chromedriver.exe");
                driver = new ChromeDriver();
            } else if (readProperty.getPropValue("browser").equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//Internal Libs//Drivers//FirefoxDriver//geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (readProperty.getPropValue("browser").equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//src//Internal Libs//Drivers//IE or EdgeDriver//IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else {
                System.out.println("Enter the Browser");
            }
        }

        driver.get(readProperty.getPropValue("url"));
        driver.manage().window().maximize();

    }

    public void stopDriver(){
        driver.quit();
    }

}
