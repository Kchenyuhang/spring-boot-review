package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/14
 */
public interface UserSpringRepository extends JpaRepository<User, Long> {
}
