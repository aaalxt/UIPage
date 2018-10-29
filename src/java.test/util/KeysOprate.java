package util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.DriverObject;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by wb-caolina on 2017/07/10.
 */
public class KeysOprate {
   // private static WebDriver driver;
    private static WebDriver driver;
   // private Actions Actionsaction;



    public static void getEnter(WebElement element) throws UnknownHostException { //键盘操作enter键
        driver= DriverObject.getDriver();
        Actions action = new Actions(driver);
        action.sendKeys(element,Keys.ENTER).perform();

      //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);

    }

    public static void getUp(WebElement element) throws UnknownHostException { //键盘操作上移键
        driver= DriverObject.getDriver();
        Actions action = new Actions(driver);
        action.sendKeys(element,Keys.ARROW_UP).perform();

        //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);

    }

    public static void getDown(WebElement element) throws UnknownHostException { //键盘操作下移键
        driver= DriverObject.getDriver();
        Actions action = new Actions(driver);
        action.sendKeys(element,Keys.ARROW_DOWN).perform();

        //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);

    }



    /**模拟鼠标悬浮在某元素上
     */
    public static void moveToElement(WebElement element) {

        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

    }

    public static String sort(String str) {
        //把字符串转化成字符数组
        char[] chs = stringToCharArray(str);

        //对字符数组进行排序
        charSort(chs);

        //把字符数组转化成字符串
        String s = new String(chs);

        return s;
    }

    private static void charSort(char[] chs) {
        // Mr_Qu's CODE HERE HERE HERE!!!
        Arrays.sort(chs);

    }

    private static char[] stringToCharArray(String str) {
        // Mr_Qu's CODE HERE HERE HERE!!!

        return str.toCharArray();
    }








//    public static void main(String... args){
//        String specDate = getSpecDate(Calendar.DAY_OF_MONTH, 2);
//        System.out.println(specDate);
//    }
}
