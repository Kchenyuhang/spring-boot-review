package com.soft1851.springboot.task.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yhChen
 * @Description:通过@EnableScheduling开启定时
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootTaskSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskSchedulingApplication.class, args);
    }

}
