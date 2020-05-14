package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.cascade.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/13
 */
public interface StudentRepository extends JpaSpecificationExecutor<Student>, JpaRepository<Student, Integer> {

    /**
     * 根据班级id查询学生姓名
     *
     * @param clazzId
     * @return List<Student>
     */
    @Query(value = "select * from student where clazz_id = ?1", nativeQuery = true)
    List<Student> findByClazzId(int clazzId);
}
