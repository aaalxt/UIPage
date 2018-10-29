package webdriver.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import webdriver.PageProxy;
import webdriver.annotation.Page;
import webdriver.annotation.ScrollIntoView;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by wb-zyc239372 on 2017/3/6.
 */
public class ElementFieldDecorator implements FieldDecorator{
    private ElementLocatorFactory locatorFactory;

    public ElementFieldDecorator(ElementLocatorFactory locatorFactory) {
        this.locatorFactory = locatorFactory;
    }

    public Object decorate(ClassLoader classLoader, Field field) {
        ScrollIntoView scrollIntoView = field.getAnnotation(ScrollIntoView.class);
        boolean baseTop = scrollIntoView == null? false:scrollIntoView.value();
        if(!WebElement.class.isAssignableFrom(field.getType()) && !this.isDecoratableList(field)) {
            Page annotation = field.getDeclaringClass().getAnnotation(Page.class);
            if(annotation != null){
                PageProxy proxy = new PageProxy();
                return proxy.getInstance(field.getDeclaringClass());
            }
            return null;
        } else {
            ElementLocator locator = this.locatorFactory.createLocator(field);
            return locator == null?null:(WebElement.class.isAssignableFrom(field.getType())?this.proxyForLocator(classLoader, locator,baseTop, field):(List.class.isAssignableFrom(field.getType())?this.proxyForListLocator(classLoader, locator, field):null));
        }
    }

    private boolean isDecoratableList(Field field) {
        if(!List.class.isAssignableFrom(field.getType())) {
            return false;
        } else {
            Type genericType = field.getGenericType();
            if(!(genericType instanceof ParameterizedType)) {
                return false;
            } else {
                Type listType = ((ParameterizedType)genericType).getActualTypeArguments()[0];
                return !WebElement.class.equals(listType)?false:field.getAnnotation(FindBy.class) != null || field.getAnnotation(FindBys.class) != null || field.getAnnotation(FindAll.class) != null;
            }
        }
    }

    protected WebElement proxyForLocator(ClassLoader loader, ElementLocator locator, boolean scrollIntoView, Field field) {
        LocatingIElementHandler handler = new LocatingIElementHandler(locator, scrollIntoView, field);
        WebElement proxy = (WebElement) Proxy.newProxyInstance(loader, new Class[]{WebElement.class, WrapsElement.class, Locatable.class}, handler);
        return proxy;
    }

    protected List<WebElement> proxyForListLocator(ClassLoader loader, ElementLocator locator, Field field) {
        LocatingIListElementHandler handler = new LocatingIListElementHandler(locator, field);
        List proxy = (List)Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
        return proxy;
    }
}
