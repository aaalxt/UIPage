package webdriver.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import webdriver.DriverObject;

import java.lang.reflect.Field;
import java.net.UnknownHostException;

/**
 * Created by wb-zyc239372 on 2017/3/6.
 */
public class ElementFactory {
    public static void init(Object object, Class cls) throws UnknownHostException {
        WebDriver driver = DriverObject.getDriver();
        ElementLocatorFactory factory = new DefaultElementLocatorFactory(driver);
        ClassLoader classLoader = cls.getClassLoader();
        for(Field field :cls.getDeclaredFields()){
            Object retValue = proxyField(field, factory, classLoader);
            if(!field.isAccessible()) field.setAccessible(true);
            try {
                field.set(object, retValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static Object proxyField(Field field, ElementLocatorFactory factory, ClassLoader classLoader){
        ElementFieldDecorator elementFieldDecorator = new ElementFieldDecorator(factory);
        return elementFieldDecorator.decorate(classLoader, field);
    }


}
