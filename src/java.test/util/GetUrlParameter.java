package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriver.DriverObject;

import java.net.UnknownHostException;
import java.util.*;

/**
 * Created by wb-zhy302094 on 2017/7/12.
 */
public class GetUrlParameter {

    /**
     * 去掉url中的路径，留下请求参数部分
     *
     * @param strURL url地址
     * @return url请求参数部分
     * @author lzf
     */
    private static String TruncateUrlPage(String strURL) {
        String strAllParam = null;
        String[] arrSplit = null;
        strURL = strURL.trim().toLowerCase();
        arrSplit = strURL.split("[?]");
        if (strURL.length() > 1) {
            if (arrSplit.length > 1) {
                for (int i = 1; i < arrSplit.length; i++) {
                    strAllParam = arrSplit[i];
                }
            }
        }
        return strAllParam;
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     *
     * @param URL url地址
     * @return url请求参数部分
     * @author lzf
     */
    public static Map<String, String> urlSplit(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit = null;
        String strUrlParam = TruncateUrlPage(URL);
        if (strUrlParam == null) {
            return mapRequest;
        }
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    //关闭新打开的当前浏览器窗口，定位到第i个浏览器窗口 //i=0 第一个
    public static void getIntchrome(int i) {
        WebDriver driver = null;
        try {
            driver = DriverObject.getDriver();
            Set<String> winHandels = driver.getWindowHandles(); // 得到当前窗口的set集合
            List<String> it = new ArrayList<String>(winHandels); // 将set集合存入list对象
            driver.close();
            driver.switchTo().window(it.get(i)); // 切换到弹出的新窗口
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


//切换url
    public static void getWindow(String url){
        WebDriver driver = null;
        try {
            driver = DriverObject.getDriver();
            driver.get(url);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }



    //浏览器后退
    public static void back() {
        try {
            WebDriver driver=DriverObject.getDriver();
            driver.navigate().back();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //浏览器刷新
    public static void refresh() {
        try {
            WebDriver driver=DriverObject.getDriver();
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //frame
    public static void frameElement(String id) {
        try {
            WebDriver driver=DriverObject.getDriver();
            driver.switchTo().frame(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //frame
    public static void frameElementexit(String id) {
        try {
            WebDriver driver=DriverObject.getDriver();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //元素是否存在
    public static boolean doesWebElementExist(WebDriver driver, By selector) throws UnknownHostException {
        try {
            driver.findElement(selector);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }
}

