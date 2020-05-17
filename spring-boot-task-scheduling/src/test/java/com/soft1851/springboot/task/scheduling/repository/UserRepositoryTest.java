package com.soft1851.springboot.task.scheduling.repository;

import com.soft1851.springboot.task.scheduling.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/17
 */
@SpringBootTest
class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    void findAll() {
        List<User> user = userRepository.findAll();
        user.forEach(System.out::println);
    }
}