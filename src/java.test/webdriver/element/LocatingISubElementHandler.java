package webdriver.element;

import org.openqa.selenium.WebElement;
import webdriver.Operation.Operation;
import webdriver.PathCache;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;

/**
 * Created by wb-zyc239372 on 2017/3/16.
 */
public class LocatingISubElementHandler implements InvocationHandler{
    private WebElement webElement;

    public LocatingISubElementHandler(WebElement webElement) {
        this.webElement = webElement;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object object = null;
        if("sendkey".equalsIgnoreCase(methodName) || "click".equalsIgnoreCase(methodName))
            Operation.highLight(webElement);
        if("clear".equalsIgnoreCase(methodName))
            Operation.clearContent(webElement);
        else{
            try{
                object = method.invoke(webElement, args);
            }catch (InvocationTargetException e){
                if(e.getCause().getMessage().contains("Element is not clickable")){
                    Operation.click(webElement);
                }
            }
        }
        takePicture();
        return object;
    }

    private void takePicture() throws UnknownHostException {
        String path = PathCache.getPath() + File.separator + PathCache.getFileNum() + ".png";
        Operation.takeScreenPhoto(path);
    }
}
