package com.soft1851.springboot.jpa.model.cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/13
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column
    private String teacherName;
    @Column(name = "clazz_id")
    private Integer clazzId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clazz_id", referencedColumnName = "clazz_id",insertable = false, updatable = false)
    private Clazz clazz;

}
