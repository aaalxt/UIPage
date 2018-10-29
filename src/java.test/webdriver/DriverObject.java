package webdriver;

import org.jtester.module.core.helper.ConfigurationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webdriver.annotation.DriverType;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by wb-zyc239372 on 2017/3/6.
 */
public class DriverObject {
    private final static ThreadLocal<WebDriver> webThreadLocal = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() throws UnknownHostException {
        WebDriver webDriver = webThreadLocal.get();
        if(webDriver == null){
            webDriver = generateDriver();
        }
        return webDriver;
    }

    public static WebDriver generateDriver() throws UnknownHostException {
        String driverName = ConfigurationHelper.getString("driver.type");
        //driverName="chrome";
        DriverType driverType = DriverType.getDriverType(driverName);

        WebDriver webDriver = null;
        switch (driverType){
            case chrome:

                InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址
                String hostAddress = address.getHostAddress();
                String driverLocation="D:\\chromedriver.exe";
                /* if (hostAddress.equals("100.69.199.198"))

                 {
                driverLocation = driverLocation(58);}
                else

                 {
                     driverLocation = driverLocation(58);}*/


             //   System.setProperty("webdriver.chrome.driver",
              //          "D:\\chromedriver.exe");
              //  webDriver = WebDriverFactory.createChromeWebDriver();
                System.setProperty("webdriver.chrome.driver", driverLocation);
                webDriver = new ChromeDriver();

                break;
            case fireFox:

                break;
            case IE:
                break;
        }
        webThreadLocal.set(webDriver);
        return webDriver;
    }

    public static void close() throws UnknownHostException {
        WebDriver driver = getDriver();
        //driver.close();
        driver.quit();
        webThreadLocal.remove();
    }


    private static String driverLocation(){
        String osName = System.getProperty("os.name");
        URL resource = null;
        if(osName.toLowerCase().startsWith("window"))
         //   {resource = DriverObject.class.getClassLoader().getResource("driver/chromedriver.exe");}
        {resource = DriverObject.class.getClassLoader().getResource("D:\\chromedriver.exe");}

        else
            resource = DriverObject.class.getClassLoader().getResource("D:\\chromedriver.exe");
        return resource.getFile();
    }


    private static String driverLocation(int chromeid){
        String osName = System.getProperty("os.name");
        URL resource = null;
        if(osName.toLowerCase().startsWith("window"))
            {resource = DriverObject.class.getClassLoader().getResource("D:\\chromedriver.exe");}


        else
            resource = DriverObject.class.getClassLoader().getResource("D:\\chromedriver.exe");
        return resource.getFile();
    }
}