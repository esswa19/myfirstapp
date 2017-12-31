package pageFactory_pom;

import utilities.readWebElement;

import java.util.NoSuchElementException;

public class MercuryHomePage {

    readWebElement webelement = new readWebElement();

    public void signon(){

        try {
            webelement.click("Signon");
            System.out.println("User wants to sign on into application - clicked SignOn");
        }catch (NoSuchElementException e){
            System.err.format("No Such element Found - SignOn");
        }
    }
}
