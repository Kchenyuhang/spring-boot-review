package com.soft1851.springboot.task.scheduling.controller;

import com.soft1851.springboot.task.scheduling.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/16
 */
@RestController
@Slf4j
public class AsyncController {

    @Resource
    private AsyncTaskService asyncTaskService;

    @RequestMapping("/asyncTask")
    public String asyncTask() {
        asyncTaskService.asyncTask();
        log.info("=======================》》主线程：" + Thread.currentThread().getName());
        return "邮件已发送";
    }
}
