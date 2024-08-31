package top.ethanliang.Domain;

import lombok.Data;

@Data
public class SignOutPojo {
    /**
     * @ author ethan
     * @ date  2024年08月28日 下午1:13
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    private String username;
    private String password;
    private String description;
    private String introduce;
    private String gender;
    private int age;
}
