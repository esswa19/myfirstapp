package utilities;

import configuration.config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class readWebElement {

    config configdriver = new config();
    public WebDriver driver = configdriver.driver;
    readPropfile readProperty = new readPropfile();

    public WebElement findElement(String element) {

        String elementResp = readProperty.getPropValue(element);

        String[] elementResp_arr = elementResp.split("=");
        String locatorType = elementResp_arr[0];
        String value = '\"' + elementResp_arr[1] + '\"';

        By by;
        if ("id".equalsIgnoreCase(locatorType)) {
            by = By.id(value);
        } else if ("name".equals(locatorType)) {
            by = By.name(value);
        } else if ("xpath".equals(locatorType)) {
            by = By.xpath(value);
        } else if ("css".equals(locatorType)) {
            by = By.cssSelector(value);
        } else if ("linkText".equals(locatorType)) {
            by = By.linkText(value);
        } else if ("partialLinkText".equals(locatorType)) {
            by = By.partialLinkText(value);
        } else {
            by = null;

        }

        return driver.findElement(by);
    }

    public WebElement readElement(String element){


        readProperty.readPropData(System.getProperty("user dir")+"//src//main//resources//objectResp.properties");

        return findElement(element);
    }

    public void cleanText(String element){

        findElement(element).clear();
    }

    public void sendValue(String elemet,String value){

        findElement(elemet).sendKeys(value);
    }

    public void click(String element){

        findElement(element).click();
    }
}
