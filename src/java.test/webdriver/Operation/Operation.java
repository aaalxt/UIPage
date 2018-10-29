package webdriver.Operation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import webdriver.DriverObject;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by wb-zyc239372 on 2017/3/7.
 */
public class Operation {
    public static void highLight(WebElement webElement) throws UnknownHostException {
        WebDriver driver = DriverObject.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red'", webElement);
    }

    public static void scrollIntoView(boolean basedByTop, WebElement element) throws UnknownHostException {
        WebDriver driver = DriverObject.getDriver();
        if (basedByTop) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        }
    }

//    public static void getShowdowElement(WebElement outer, WebElement inner){
//        WebDriver driver = DriverObject.getDriver();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].shadow.arguments[1]", webElement);
//    }

    public static void clearContent(WebElement element){
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
    }

    public static void click(WebElement element) throws UnknownHostException {
        WebDriver driver = DriverObject.getDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click(element);
    }

    public static void open(String url) throws UnknownHostException {
        WebDriver driver = DriverObject.getDriver();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static String getUrl() throws UnknownHostException {
        WebDriver driver = DriverObject.getDriver();
        return driver.getCurrentUrl();
    }

    public static void takeScreenPhoto(String filename) throws UnknownHostException {
        WebDriver driver = DriverObject.getDriver();
        TakesScreenshot takesScreenshot = (TakesScreenshot )driver;
        File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAs, new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
