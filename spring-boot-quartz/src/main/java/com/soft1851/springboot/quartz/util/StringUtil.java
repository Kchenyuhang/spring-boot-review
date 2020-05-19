package com.soft1851.springboot.quartz.util;

import java.util.List;

/**
 * @Author: yhChen
 * @Date: 2020/5/18
 * @Description: 自定义枚举单例对象 StringUtil
 */
public enum StringUtil {
    ;

    /**
     * 获取List参数值
     * @param list
     * @return
     */
    public static String getListString(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s).append(" ");
        }
        return result.toString();
    }
}