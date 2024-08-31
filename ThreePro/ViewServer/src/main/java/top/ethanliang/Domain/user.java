package top.ethanliang.Domain;

import lombok.Data;

@Data
public class user {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:26
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    private String id;
    private String username;
    private String description;
    private String introduce;
    private String gender;
    private int age;
}
