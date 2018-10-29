package com.ali.jskuli.patent;

import org.apache.commons.io.FileUtils;
import org.jtester.module.database.util.SqlRunner;
import org.jtester.spec.JSpec;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import webdriver.DriverObject;
import webdriver.PageProxy;
import webdriver.PathCache;
import webdriver.annotation.Page;
import webdriver.element.ElementFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import static webdriver.constants.CommonConstants.PICTURE_FILE;

/**
 * Created by wb-zyc239372 on 2017/3/14.
 */
public abstract class BaseTest extends JSpec{
    @BeforeClass
    @Override
    public void aBeforeClass(ITestContext context) {
        for(Class cls = this.getClass(); cls.getSuperclass() != Object.class; cls = cls.getSuperclass()){
            try {
                instancePageField(this, cls);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        super.aBeforeClass(context);
        try {
            DriverObject.getDriver();    //打开浏览器等操作
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Override
    public void zAfterClass() {
        try {
            DriverObject.close();    //浏览器关闭
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        List<String> errorPath = PathCache.getErrorPath();
        if(errorPath == null || errorPath.size() == 0){   //报错图片 正确的删掉，错误的留下
            //删除class目录
            try {
                FileUtils.deleteDirectory(new File(PICTURE_FILE + File.separator + this.getClass().getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
            PathCache.resetErrorPath();
        super.zAfterClass();
    }


    //初始化@page所标记的所有
    private void instancePageField(Object object, Class cls) throws UnknownHostException {
        Field[] declaredFields = cls.getDeclaredFields();
        for(Field field : declaredFields){
            Page annotation = field.getType().getAnnotation(Page.class);
            if(annotation != null){
                PageProxy proxy = new PageProxy();
                Object proxy1 = proxy.getInstance(field.getType());
                ElementFactory.init(proxy1, field.getType());
                if(!field.isAccessible()) field.setAccessible(true);
                try {
                    field.set(object, proxy1);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String getField(String sql, String field){
        Map<String, Object> object = SqlRunner.queryMap(sql);
        return object.get(field).toString();
    }

    protected Map<String, Object> getMap(String sql){
        Map<String, Object> object = SqlRunner.queryMap(sql);
        return object;
    }

    public void getDriver(){
        try {
            DriverObject.getDriver();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // return object;
    }


}

