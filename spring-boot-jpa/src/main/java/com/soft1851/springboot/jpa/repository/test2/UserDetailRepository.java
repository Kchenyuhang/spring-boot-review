package com.soft1851.springboot.jpa.repository.test2;

import com.soft1851.springboot.jpa.model.UserDetail;
import com.soft1851.springboot.jpa.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/13
 */
public interface UserDetailRepository extends JpaSpecificationExecutor<UserDetail>, JpaRepository<UserDetail, Long> {
    /**
     *
     * @param hobby
     * @return
     */
    @Query("select u.userName as userName,u.age as age, d.introduction as introduction , d.hobby as hobby from User u , UserDetail d " +
            "where u.userId=d.userId  and  d.hobby = ?1 ")
    List<UserInfo> findUserInfo(String hobby);
}
