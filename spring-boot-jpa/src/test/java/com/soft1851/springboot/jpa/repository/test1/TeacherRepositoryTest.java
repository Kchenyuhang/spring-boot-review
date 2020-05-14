package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.cascade.Teacher;
import com.soft1851.springboot.jpa.repository.test1.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void testSave() {
        Teacher teacher = Teacher.builder()
                .teacherName("Archer")
                .clazzId(1).build();
        teacherRepository.save(teacher);

        List<Teacher> teachers = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Teacher testTeacher = Teacher.builder()
                    .teacherName("teacher0" + i)
                    .clazzId(i).build();
            teachers.add(testTeacher);
        }
        teacherRepository.saveAll(teachers);
        assertEquals(4, teacherRepository.findAll().size());
    }

    @Test
    void testOneToOne() {
        Teacher teacher = teacherRepository.findTeacherByTeacherId(1);
        log.info(teacher.toString());
    }
}