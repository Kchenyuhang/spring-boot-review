package com.soft1851.springboot.jpa.repository.test2;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author yhChen
 * @Description 基础的UserRepository，从父接口继承CRUD findBy返回一个User，findUsersBy返回一组User
 * @Date 2020/5/13
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据方法名解析：按userName和password查询唯一记录
     *
     * @param userName
     * @param password
     * @return user
     */
    User findByUserNameAndPassword(String userName, String password);

    /**
     * 根据方法名解析：按nickName模糊查询一组记录
     *
     * @param nickName
     * @return List<User>
     */
    List<User> findByNickName(String nickName);

    /**
     * 根据方法名解析：查询年龄大于指定age的所有用户
     *
     * @param age
     * @return List<User>
     */
    List<User> findUsersByAgeGreaterThan(int age);

    /**
     * 查询nickName中带有keywords的所有记录
     * @param keywords
     * @return List<User>
     */
    List<User> findUserByNickNameLike(String keywords);

    /**
     * 自定义JPQL查询，类似 Hibernate的 HQL语法，在接口上使用 @Query
     *
     * @param userId
     * @return User
     */
    @Query("select u from User u where u.userId = ?1")
    User findById(long userId);

    /**
     * 按id修改nickName
     *
     * @param nickName
     * @param userId
     * @return int
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update user set nick_name = ?1 where user_id = ?2", nativeQuery = true)
    int updateNickName(String nickName, long userId);


    /**
     * 插入
     *
     * @param userName
     * @param password
     * @param nickName
     * @return int
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "insert into user(user_name, password,nick_name) values (:userName, :password,:nickName)", nativeQuery = true)
    int insertUser(@Param("userName") String userName, @Param("password") String password, @Param("nickName") String nickName);

    /**
     * 自定义查询所有
     * @return List<User>
     */
    @Query("select u from User u")
    List<User> definedFindAll();

    /**
     * 通过@NamedQueries自定义根据age查询
     * @param age
     * @return List<User>
     */
    List<User> findByAge(Integer age);

    /**
     * 通过@NamedQueries自定义根据password查询
     * @param password
     * @return List<User>
     */
    List<User> findByPassword(String password);

    /**
     * 自定义分页查询所有
     * @param pageable
     * @return Page<User>
     */
    @Query("select u from User u")
    Page<User> findAllByPage(Pageable pageable);

    /**
     * 自定义分页根据nickName模糊查询
     * @param nickName
     * @param pageable
     * @return Page<User>
     */
    Page<User> findByNickName(String nickName, Pageable pageable);

    /**
     *
     * @param nickName
     * @param age
     * @param pageable
     * @return Slice<User>
     */
    Slice<User> findByNickNameAndAge(String nickName, Integer age, Pageable pageable);


}
