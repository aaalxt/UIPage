package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-zyc239372 on 2016/12/1.
 */
public class DateUtil {


    public static String gettoday(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String today = df.format(new Date());// new Date()为获取当前系统时间
        return  today;
    }


    public static String gettomorror(int i){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, i);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrow=sdf.format(date);
        return  tomorrow;
    }

    public static String getdayYMD(String s) throws ParseException {

        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        String day = dateFormater.format(dateFormater.parse(s));
        return  day;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    /*
     * 将时间戳转换为时间 yyyy-MM-dd
     */
    public static String stampToDateYMD(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static Map<String, Long> timeDiffer(String date1, Date d2) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date d1 = df.parse(date1);
//            Date d2 = df.parse(date2);
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);

            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            //long seconds = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60)/(1000* 60);
            System.out.println(""+days+"天"+hours+"小时"+minutes+"分");

        Map<String, Long> map = new HashMap<String, Long>();
        map.put("days",days);
        map.put("hours",hours);
        map.put("minutes",minutes);
        //map.put("seconds",seconds);
        return map;

    }



//    public static void main(String... args){
//        String specDate = getSpecDate(Calendar.DAY_OF_MONTH, 2);
//        System.out.println(specDate);
//    }
}
