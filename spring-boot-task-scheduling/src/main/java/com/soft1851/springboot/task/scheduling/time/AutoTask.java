package com.soft1851.springboot.task.scheduling.time;

import com.soft1851.springboot.task.scheduling.model.Cron;
import com.soft1851.springboot.task.scheduling.repository.CronRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/15
 */
@Slf4j
@Configuration
@Component
public class AutoTask implements SchedulingConfigurer {
    @Resource
    private CronRepository cronRepository;

    private String newCron = "0/5 * * * * ?";
    private Integer cronId = 1;

    @Bean
    public Executor setTaskExecutors() {
        //创建一个基本大小为3的线程池
        return Executors.newScheduledThreadPool(3);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                //1、添加任务内容
                () -> {
                },
                //2、设置执行周期
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronRepository.findCronByCronIdEquals(cronId).getCron();
                    //2.2 合法性校验
                    if (StringUtils.isEmpty(cron)) {
                        log.info("cron不能为空");
                    }
                    return new CronTrigger(newCron).nextExecutionTime(triggerContext);
                });
    }
}
