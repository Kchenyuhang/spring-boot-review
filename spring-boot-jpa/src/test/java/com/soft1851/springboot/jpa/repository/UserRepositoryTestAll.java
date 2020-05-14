package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.User;
import com.soft1851.springboot.jpa.repository.test1.UserSpringRepository;
import com.soft1851.springboot.jpa.repository.test2.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/14
 */
@SpringBootTest
@Slf4j
public class UserRepositoryTestAll {
    @Resource
    private UserRepository userRepository;
    @Resource
    private UserSpringRepository userSpringRepository;

    @Test
    void testSave() {
        User user = User.builder()
                .userName("saber")
                .password("saber123")
                .nickName("lion")
                .age(20)
                .regTime(LocalDateTime.now()).build();
        userRepository.save(user);
        userSpringRepository.save(user);

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            User testUser = User.builder()
                    .userName("user" + i)
                    .password("user" + i)
                    .nickName("nickName" + i)
                    .age(new Random().nextInt(50))
                    .regTime(LocalDateTime.now()).build();
            users.add(testUser);
        }
        userRepository.saveAll(users);
        userSpringRepository.saveAll(users);

    }

    @Test
    void testSelectAll() {
        List<User> list1 = userRepository.findAll();
        log.info(String.valueOf(list1.size()));
        List<User> list2 = userSpringRepository.findAll();
        log.info(String.valueOf(list2.size()));
    }
}
