package com.soft1851.springboot.task.scheduling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "avatar",nullable = false,length = 200)
    private String avatar;

    @Column(name = "url",nullable = false,length = 200)
    private String url;
}
