package util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webdriver.DriverObject;

import java.net.UnknownHostException;

/**
 * Created by wb-caolina on 2017/07/10.
 */
public class CommonServices {
   // private static WebDriver driver;
    private static WebDriver driver;
   // private Actions Actionsaction;


    public static boolean doesWebElementExist(WebElement element) throws UnknownHostException {
               driver= DriverObject.getDriver();
              try
               {
                   driver.findElement((By) element);
                   return true;
               } catch (NoSuchElementException e)
               {
                             return false;
                   }
         }









//    public static void main(String... args){
//        String specDate = getSpecDate(Calendar.DAY_OF_MONTH, 2);
//        System.out.println(specDate);
//    }
}
