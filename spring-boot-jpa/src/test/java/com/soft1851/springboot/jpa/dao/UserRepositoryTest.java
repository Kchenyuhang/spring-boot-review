package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Message;
import com.soft1851.springboot.jpa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/12
 */
@Slf4j
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserName() {
        User item = userRepository.findByUserName("archer");
        log.info(String.valueOf(item));
    }

    @Test
    void findByUserNameOrAge() {
        User item = userRepository.findByUserNameOrAge("saber",20);
        log.info(String.valueOf(item));
    }

}