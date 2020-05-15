package com.soft1851.springboot.task.scheduling.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/15
 */
@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;
    @Resource
    private TemplateEngine templateEngine;

    @Test
    void sendSimpleTextMail() {
        String to = "2369301070@qq.com";
        String subject = "SpringBoot 发送简单文本邮件";
        String content = "<h3>第一封 SpringBoot 简单文本邮件</h3>";
        mailService.sendSimpleTextMail(to, subject, content);
    }

    @Test
    void sendHtmlMail() throws Exception {
        String to = "2369301070@qq.com";
        String subject = "SpringBoot 发送 HTML 邮件";
        String content = "<h3>第一封 SpringBoot HTML邮件</h3>";
        mailService.sendHtmlMail(to, subject, content);
    }

    @Test
    void sendAttachmentMail() throws Exception {
        String to = "2369301070@qq.com";
        String subject = "SpringBoot 发送 附件 邮件";
        String content = "<h3>第一封 SpringBoot 附件邮件</h3>";
        String imgPath = "D:\\resources\\test.docx";
        mailService.sendAttachmentMail(to, subject, content, imgPath);
    }

    @Test
    public void sendTemplateMail() throws Exception {
        //创建邮件字段
        Context context = new Context();
        context.setVariable("siteTitle", "【阅片无数46】");
        context.setVariable("permalink", "https://www.bilibili.com/video/BV1Gt4y117MH");
        context.setVariable("title", "你管这叫抢银行？");
        context.setVariable("author", "测试员");
        context.setVariable("time", "2019-07-16 08:52:46");
        context.setVariable("text", "专业！");
        context.setVariable("ip", "127.0.0.1");
        context.setVariable("mail", "1797262364@qq.com");
        context.setVariable("status", "通过");
        context.setVariable("manage", "https://www.bilibili.com");
        // 将字段加载到页面模板中
        String emailContent = templateEngine.process("Card", context);
        mailService.sendHtmlMail("2369301070@qq.com","主题：这是模板邮件【Blibili小破站】",emailContent);
    }

    @Test
    void sendImgMail() throws Exception {
        String to = "2369301070@qq.com";
        String subject = "SpringBoot 发送 图片 邮件";
        String content = "<h3>第一封 SpringBoot 图片邮件</h3><br/><img src=\"cid:img01\" />";
        String imgPath = "D:\\resources\\pictures\\result1.jpg";
        Map<String, String> imgMap = new HashMap<>();
        //以键值对的形式存入
        imgMap.put("img01", imgPath);
        mailService.sendImgMail(to, subject, content, imgMap);
    }
}