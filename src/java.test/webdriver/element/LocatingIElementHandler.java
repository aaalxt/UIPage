package webdriver.element;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jtester.module.core.helper.ConfigurationHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import webdriver.DriverObject;
import webdriver.Operation.Operation;
import webdriver.Operation.Sleeper;
import webdriver.PathCache;
import webdriver.annotation.WaitDispear;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by wb-zyc239372 on 2017/3/6.
 */
public class LocatingIElementHandler implements InvocationHandler{
    private static final Logger logger = LogManager.getLogger(LocatingIElementHandler.class);
    private final ElementLocator locator;
    private final boolean scrolIntoView;
    private final Field field;
    private final String timeout;
    private final String interVal;

    public LocatingIElementHandler(ElementLocator locator, boolean scrolIntoView, Field field) {
        this.locator = locator;
        this.scrolIntoView = scrolIntoView;
        this.field = field;
        timeout = ConfigurationHelper.getString("webElement.timeout") == null?"5":ConfigurationHelper.getString("webElement.timeout");
        interVal = ConfigurationHelper.getString("webElement.waitInterval") == null?"500":ConfigurationHelper.getString("webElement.waitInterval");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Set<String> oldWindows = getWindowsNum();
        WebElement element = findElement(locator);

        if(element == null){
            logger.error("the " + field.getName()
                    + " element can't be found and the time(" + (Integer.valueOf(timeout) * Integer.valueOf(interVal)) + ") is out");
            throw new RuntimeException("the " + field.getName()
                    + " element can't be found and the time(" + (Integer.valueOf(timeout) * Integer.valueOf(interVal)) + ") is out");
        }
        if ("getWrappedElement".equals(method.getName())) {
            return element;
        }
        String methodName = method.getName();
        if("click".equals(methodName) || "sendKeys".equals(methodName) || "input".equalsIgnoreCase(element.getTagName())){
            Operation.highLight(element);
            Operation.scrollIntoView(scrolIntoView, element);
        }

        Object object = null;
        try {
            if(methodName.equalsIgnoreCase("clear")){
                Operation.clearContent(element);
            }else
                object = method.invoke(element, args);
        } catch (InvocationTargetException e) {
            if(e.getCause().getMessage().contains("Element is not clickable")){
                Operation.click(element);
            }
        }
        takePicture();
        Set<String> newWindows = getWindowsNum();
        switchWindow(oldWindows, newWindows);
        WaitDispear annotation = field.getAnnotation(WaitDispear.class);
        if(annotation != null)
            Sleeper.sleep(Long.valueOf(annotation.value()));
        return object;
    }

    //寻找网页元素
    private WebElement findElement(ElementLocator locator){
        int count = 0;
        WebElement element = null;
        while ((element = locateElement(locator))== null && count++ <= Integer.valueOf(timeout)){
            Sleeper.sleep(interVal);
        };
        return element;
    }

    private WebElement locateElement(ElementLocator locator){
        WebElement element = null;
        try {
            element = locator.findElement();
        }catch (NoSuchElementException e){

        }
        return element;
    }

    private Set<String> getWindowsNum() throws UnknownHostException {
        WebDriver driver = DriverObject.getDriver();
        return driver.getWindowHandles();
    }

    private void switchWindow(Set<String> oldWindows, Set<String> newWindows) throws UnknownHostException {
        String[] oldStrings = oldWindows.toArray(new String[oldWindows.size()]);
        String[] newStrings = newWindows.toArray(new String[newWindows.size()]);
        WebDriver driver = DriverObject.getDriver();
        if(oldStrings.length != newStrings.length){
            driver.switchTo().window(newStrings[newStrings.length - 1]);
        }
    }

    private void takePicture() throws UnknownHostException {
        String path = PathCache.getPath() + File.separator + PathCache.getFileNum() + ".png";
        Operation.takeScreenPhoto(path);
    }
}
