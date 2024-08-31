package top.ethanliang;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class TimeTest {
    /**
     * @ author ethan
     * @ date  2024年08月30日 下午3:54
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Test
    public void test() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ld = LocalDateTime.now();
        String now = df.format(ld);
        System.out.println(now);
    }
}
