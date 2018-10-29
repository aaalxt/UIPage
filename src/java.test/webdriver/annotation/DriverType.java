package webdriver.annotation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-zyc239372 on 2017/3/6.
 */
public enum  DriverType {
    chrome,
    fireFox,
    IE;
    private static Map<String, DriverType> driverTypeMap = new HashMap<String, DriverType>();
    static {
        for(DriverType type : values()){
            driverTypeMap.put(type.name(), type);
        }
    }

    public static DriverType getDriverType(String name){
        return driverTypeMap.get(name);
    }
}
