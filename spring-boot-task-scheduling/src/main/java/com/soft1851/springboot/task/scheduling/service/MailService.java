package com.soft1851.springboot.task.scheduling.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/15
 */
public interface MailService {
    /**
     * 发送简单的文本邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleTextMail(String to, String subject, String content);

    /**
     * 发送 HTML 邮件
     *
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;

    /**
     * 发送附件邮件
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     * @throws MessagingException
     */
    void sendAttachmentMail(String to, String subject, String content, String... fileArr) throws MessagingException;

    /**
     * 发送图片邮件
     * @param to 接收方
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param imgMap 图片
     * @throws MessagingException
     */
    void sendImgMail(String to, String subject, String content, Map<String,String> imgMap) throws MessagingException;

//    /**
//     * 发送定时邮件
//     * 使用图片模板
//     * @param to
//     * @param subject
//     * @param content
//     * @param imgMap
//     * @throws MessagingException
//     */
//    void sendTimeImageMail(String to, String subject, String content, Map<String,String> imgMap) throws MessagingException;
}
