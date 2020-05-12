package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/12
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 通过userName查询
     * @param userName
     * @return User
     */
    User findByUserName(String userName);

    /**
     * 根据userName或age查询
     * @param userName
     * @param age
     * @return
     */
    User findByUserNameOrAge(String userName, Integer age);

    /**
     * 根据userId删除
     * @param userId
     * @return
     */
    int deleteByUserId(Integer userId);
}
