import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * @author He.H
 * @date 2019/1/18 21:10
 **/




public class TimeString {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}
