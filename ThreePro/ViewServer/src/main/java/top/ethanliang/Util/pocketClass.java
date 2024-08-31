package top.ethanliang.Util;

import lombok.Data;

@Data
public class pocketClass {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午1:15
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    private int Code;
    private String message;
    private Object data;

    public pocketClass( String message,int code) {
        Code = code;
        this.message = message;
    }


    public pocketClass(String message, int code, Object data) {
        this.message = message;
        Code = code;
        this.data = data;
    }

}
