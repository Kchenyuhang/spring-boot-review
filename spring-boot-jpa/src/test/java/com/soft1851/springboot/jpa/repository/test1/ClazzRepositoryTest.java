package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.cascade.Clazz;
import com.soft1851.springboot.jpa.repository.test1.ClazzRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/13
 */
@SpringBootTest
@Slf4j
class ClazzRepositoryTest {

    @Autowired
    private ClazzRepository clazzRepository;

    @Test
    void testOneToMany() {
        List<Clazz> clazzList = clazzRepository.findByClazzId(1);
        clazzList.forEach(clazz -> log.info(clazz.toString()));
    }
}