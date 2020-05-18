package com.soft1851.springboot.quartz.controller.dto;

import lombok.Data;

/**
 * @Author yhChen
 * @Description 修改cron表达式的dto类
 * @Date 2020/5/18
 */
@Data
public class ModifyCronDto {
    /**
     * 作业的id
     */
    private Integer id;

    /**
     * 作业的cron表达式
     */
    private String cron;
}
