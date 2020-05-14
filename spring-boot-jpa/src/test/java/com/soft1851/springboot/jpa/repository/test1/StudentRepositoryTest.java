package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.cascade.Course;
import com.soft1851.springboot.jpa.model.cascade.Student;
import com.soft1851.springboot.jpa.repository.test1.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/13
 */
@SpringBootTest
@Slf4j
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testSave() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            Student testStudent = Student.builder()
                    .studentName("student" + i)
                    .clazzId(1)
                    .hometown("江苏常州")
                    .birthday(LocalDateTime.now()).build();
            students.add(testStudent);
        }
        studentRepository.saveAll(students);
        assertEquals(15,studentRepository.findAll().size());
    }

    @Test
    void testManyTomMany() {
        List<Student> students = studentRepository.findByClazzId(1);
        students.forEach(student -> {
            System.out.println(student.getStudentName());
            List<Course> courseList =student.getCourseList();
            courseList.forEach(course -> {
                System.out.println(course.getCourseId() + "," + course.getCourseName());
            });
        });
    }
}