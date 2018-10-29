package webdriver;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by wb-zyc239372 on 2017/3/3.
 */
public class PageProxy<T> implements MethodInterceptor{
    private static final Logger loger = LogManager.getLogger(PageProxy.class);
    private Class cls;

    public T getInstance(Class<T> tClass) {
        this.cls = tClass;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    public <T> T getInstance(T target,Class[] args,Object[] argsValue){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create(args,argsValue);
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Method[] declaredMethods = cls.getDeclaredMethods();
        String path = PathCache.getPath();
        for(Method method1 : declaredMethods){
            if(method.getName().equals(method1.getName())){
                loger.info(String.format("正在执行%s 的 %s, 参数为%s", cls.getName(), method.getName(), Arrays.deepToString(objects)));
                break;
            }
        }
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }


}
