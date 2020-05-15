package com.soft1851.springboot.task.scheduling.time;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/14
 */
//@Component
public class Task2 {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");

    /**
     * fixedRate:固定频率执行
     */
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime1() {
        System.out.println(Thread.currentThread() + "Time1-现在时间：" + dtf.format(LocalDateTime.now()));
    }

    /**
     * fixedDelay:固定延时
     */
    @Scheduled(fixedDelay = 2000)
    public void reportCurrentTime2() {
        System.out.println(Thread.currentThread() + "Time2-现在时间：" + dtf.format(LocalDateTime.now()));
    }

    /**
     * 第一次延时3秒后执行，之后按fixedDelay的规则每2秒执行一次
     */
    @Scheduled(initialDelay = 3000, fixedDelay = 2000)
    public void reportCurrentTime3() {
        System.out.println(Thread.currentThread() + "Time3-现在时间：" + dtf.format(LocalDateTime.now()));
    }

    /**
     * 通过cron表达式定义规则
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void reportCurrentTime4() {
        System.out.println("Time4-现在时间：" + dtf.format(LocalDateTime.now()));
    }
}
