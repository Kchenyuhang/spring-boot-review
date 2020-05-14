package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import com.soft1851.springboot.jpa.model.info.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/13
 */
public interface TeacherRepository extends JpaSpecificationExecutor<Teacher>, JpaRepository<Teacher, Integer> {
    /**
     * 一对一查询
     * @param teacherId
     * @return
     */
    Teacher findTeacherByTeacherId(Integer teacherId);
}
