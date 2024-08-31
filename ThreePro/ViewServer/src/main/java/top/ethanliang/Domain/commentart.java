package top.ethanliang.Domain;

import lombok.Data;

@Data
public class commentart {
    /**
     * @ author ethan
     * @ date  2024年08月27日 上午11:24
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    private String id;
    private String articleId;
    private String userGood;
    private String info;
}
