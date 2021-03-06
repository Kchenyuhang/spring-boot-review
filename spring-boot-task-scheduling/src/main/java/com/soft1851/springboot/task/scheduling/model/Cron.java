package com.soft1851.springboot.task.scheduling.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/15
 */
@Data
@Entity
public class Cron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cronId;

    @Column(name = "cron_name", nullable = false, length = 30)
    private String cronName;

    @Column(name = "cron", nullable = false, length = 50)
    private String cron;
}
