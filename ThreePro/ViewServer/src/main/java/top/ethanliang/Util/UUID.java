package top.ethanliang.Util;

import cn.hutool.core.util.IdUtil;

public class UUID {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午1:00
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    public static String get(){
        return IdUtil.fastUUID();
    }
}
