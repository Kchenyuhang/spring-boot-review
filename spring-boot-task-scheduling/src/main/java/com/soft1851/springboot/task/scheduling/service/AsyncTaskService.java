package com.soft1851.springboot.task.scheduling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.swing.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/16
 */
@Service
@Slf4j
public class AsyncTaskService {
    @Resource
    private MailService mailService;
    @Resource
    private TemplateEngine templateEngine;

    @Async
    public void asyncTask() {
        try {
            Thread.sleep(5000);
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
            mailService.sendHtmlMail("2369301070@qq.com", "主题：这是模板邮件【Blibili小破站】", emailContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("邮件发送成功");
    }
}
