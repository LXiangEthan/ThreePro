package top.ethanliang.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    /**
     * @ author ethan
     * @ date  2024年08月30日 下午3:56
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    public static String now() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ld = LocalDateTime.now();
        String now = df.format(ld);
        return now;
    }
}
