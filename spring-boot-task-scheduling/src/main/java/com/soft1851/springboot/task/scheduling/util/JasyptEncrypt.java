package com.soft1851.springboot.task.scheduling.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/17
 */
public class JasyptEncrypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密盐
        textEncryptor.setPassword("king991214");
        //加密数据
        String password = textEncryptor.encrypt("root");
        System.out.println(password);
    }
}
