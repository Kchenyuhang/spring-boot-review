package com.soft1851.springboot.quartz.task;

import com.soft1851.springboot.quartz.job.TestJob;
import com.soft1851.springboot.quartz.mananger.QuartzManager;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;

/**
 * @Author yhChen
 * @Description 动态调度任务测试类
 * @Date 2020/5/18
 */
@Slf4j
public class DynamicScheduleTask {
    public static void main(String[] args) throws SchedulerException {
//        //添加任务，注意各个参数的作用
        QuartzManager.addJob("testJob", "jobGroup1",
                "testTrigger", "triggerGroup1",
                TestJob.class, "0/5 * * * * ?");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //修改任务
        QuartzManager.modifyJobTime("testTrigger", "triggerGroup1",
                "0/3 * * * * ?");
//
//        //删除任务
//        QuartzManager.removeJob("testJob", "jobGroup1",
//                "testTrigger", "triggerGroup1");
//
//        QuartzManager.shutdownJobs();
    }
}
