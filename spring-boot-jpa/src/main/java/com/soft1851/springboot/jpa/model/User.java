package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/12
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Integer age;
}
