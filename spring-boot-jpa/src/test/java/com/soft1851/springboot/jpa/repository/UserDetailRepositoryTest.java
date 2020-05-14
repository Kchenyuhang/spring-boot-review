package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.UserInfo;
import com.soft1851.springboot.jpa.repository.test2.UserDetailRepository;
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
class UserDetailRepositoryTest {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Test
    void testUserInfo() {
        List<UserInfo> userInfos = userDetailRepository.findUserInfo("钓鱼");
        for (UserInfo userInfo : userInfos) {
            System.out.println("userInfo: " + userInfo.getUserName() + "-" + userInfo.getAge() + "-" + userInfo.getHobby() + "-" + userInfo.getIntroduction());
        }
    }
}