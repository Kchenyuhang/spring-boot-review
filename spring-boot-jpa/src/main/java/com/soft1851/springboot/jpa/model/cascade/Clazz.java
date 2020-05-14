package com.soft1851.springboot.jpa.model.cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clazz_id")
    private Integer clazzId;
    @Column
    private String clazzName;
    @Column(name = "teacher_id")
    private Integer teacherId;

    @JoinColumn(name = "clazz_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();
}
