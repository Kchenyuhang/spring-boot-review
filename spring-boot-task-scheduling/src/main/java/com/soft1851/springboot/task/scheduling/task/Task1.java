package com.soft1851.springboot.task.scheduling.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/14
 */
//@Component
public class Task1 {
    private int count = 0;

    @Scheduled(cron = "*/5 * * * * ?")
    private void process() {
        System.out.println("this is scheduler task running  " + (count++));
    }
}
