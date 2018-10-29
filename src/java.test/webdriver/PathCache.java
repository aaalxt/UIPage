package webdriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-zyc239372 on 2017/3/16.
 */
public class PathCache {
    private final static ThreadLocal<String> pathThreadLocal = new ThreadLocal<String>();
    private final static ThreadLocal<Integer> fileNumThreadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    private final static ThreadLocal<List<String>> errorPath = new ThreadLocal<List<String>>();

    public static void setPath(String path){
        pathThreadLocal.set(path);
    }

    public static void removePath(){
        pathThreadLocal.remove();
    }

    public static String getPath(){
        return pathThreadLocal.get();
    }

    public static void setFileNum(Integer fileNum){
        fileNumThreadLocal.set(fileNum);
    }

    public static Integer getFileNum(){
        Integer integer = fileNumThreadLocal.get();
        setFileNum(++integer);
        return integer;
    }

    public static void addErrorPath(String path){
        List<String> errorPaths = getErrorPath();
        if(errorPaths == null){
            errorPaths = new ArrayList<String>();
        }
        errorPaths.add(path);
    }

    public static List<String> getErrorPath(){
        return errorPath.get();
    }

    public static void resetErrorPath(){
        errorPath.remove();
    }

}
