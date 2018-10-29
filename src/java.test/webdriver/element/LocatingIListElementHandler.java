package webdriver.element;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jtester.module.core.helper.ConfigurationHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import webdriver.Operation.Operation;
import webdriver.Operation.Sleeper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by wb-zyc239372 on 2017/3/7.
 */
public class LocatingIListElementHandler implements InvocationHandler{
    private static final Logger logger = LogManager.getLogger(LocatingIListElementHandler.class);
    private final ElementLocator locator;
    private final Field field;
    private final String timeout;
    private final String interVal;
    public LocatingIListElementHandler(ElementLocator locator, Field field) {
        this.locator = locator;
        this.field = field;
        timeout = ConfigurationHelper.getString("webElement.timeout") == null?"5":ConfigurationHelper.getString("webElement.timeout");
        interVal = ConfigurationHelper.getString("webElement.waitInterval") == null?"500":ConfigurationHelper.getString("webElement.waitInterval");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<WebElement> elements = findElements();
        if(elements == null || elements.size() == 0){
            logger.error("the " + field.getName()
                    + " element can't be found and the time(" + Integer.valueOf(timeout) * Integer.valueOf(interVal) + ") is out");
            throw new RuntimeException("the " + field.getName()
                    + " element can't be found and the time(" + Integer.valueOf(timeout) * Integer.valueOf(interVal) + ") is out");
        }
        Object object = method.invoke(elements, args);
        if("get".equalsIgnoreCase(method.getName())){
            WebElement webElement = (WebElement) object;
            Operation.highLight(webElement);
            object = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{WebElement.class, WrapsElement.class, Locatable.class},new LocatingISubElementHandler(webElement));
        }
        return object;
    }

    private List<WebElement> findElements(){
        List<WebElement> elements = null;
        int count = 0;
        while (((elements = locateElements(locator)) == null || (elements = locateElements(locator)).size() == 0) && count++ < Integer.valueOf(timeout)){
            Sleeper.sleep(interVal);
        };
        return elements;
    }

    private List<WebElement> locateElements(ElementLocator locator){
        List<WebElement> elements = null;
        try {
            elements = locator.findElements();
        }catch (NoSuchElementException e){
        }
        return elements;
    }
}
