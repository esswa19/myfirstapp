package pageFactory_pom;

import utilities.readWebElement;

import java.util.NoSuchElementException;

public class MercurySignOnPage {

    readWebElement webelement = new readWebElement();

    public void login(){

        try{
            webelement.cleanText("userName");
            webelement.sendValue("userName","Eswar");
            System.out.println("User entered Username");
        }catch (NoSuchElementException e){
            System.out.println("User entered UserName - "+ e);
        }
        try{
            webelement.cleanText("password");
            webelement.sendValue("password","eswar@123");
            System.out.println("User entered Password");
        }catch (NoSuchElementException e){
            System.out.println("User entered Password - "+ e);
        }
         try{
            webelement.click("login");
             System.out.println("User clicked Login Button");
        }catch (NoSuchElementException e){
            System.out.println("User clicked Login Button - "+ e);
        }
    }
}
