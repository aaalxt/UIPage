package webdriver.Operation;

/**
 * Created by wb-zyc239372 on 2017/3/7.
 */
public class Sleeper {
    public static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(String time){
        if(time == null) throw new IllegalArgumentException("时间不能为空");
        Long aTime = Long.valueOf(time);
        sleep(aTime);
    }
}
