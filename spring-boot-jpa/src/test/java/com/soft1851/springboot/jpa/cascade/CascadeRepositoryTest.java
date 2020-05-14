package com.soft1851.springboot.jpa.cascade;

import com.soft1851.springboot.jpa.model.cascade.*;
import com.soft1851.springboot.jpa.repository.test1.ClazzRepository;
import com.soft1851.springboot.jpa.repository.test1.StudentRepository;
import com.soft1851.springboot.jpa.repository.test1.TeacherRepository;
import com.soft1851.springboot.jpa.repository.test2.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/14
 */
@SpringBootTest
@Slf4j
class CascadeRepositoryTest {
    @Resource
    private TeacherRepository teacherRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private ClazzRepository clazzRepository;
    @Resource
    private ArticleRepository articleRepository;

    @Test
    void testOneToOne() {
        Teacher teacher = teacherRepository.findTeacherByTeacherId(1);
        log.info(teacher.toString());
    }

    @Test
    void testOneToMany() {
        List<Clazz> clazzList = clazzRepository.findByClazzId(1);
        clazzList.forEach(clazz -> log.info(clazz.toString()));
    }

    @Test
    void testManyToOne() {
        Optional<Article> article = articleRepository.findById(1L);
        System.out.println(article);
    }

    @Test
    void testManyTomMany() {
        List<Student> students = studentRepository.findByClazzId(1);
        students.forEach(student -> {
//            System.out.println(student.getStudentName());
//            List<Course> courseList =student.getCourseList();
//            courseList.forEach(course -> {
//                System.out.println(course.getCourseId() + "," + course.getCourseName());
//            });
        });
    }
}
