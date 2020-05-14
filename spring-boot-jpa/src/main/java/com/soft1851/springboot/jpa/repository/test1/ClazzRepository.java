package com.soft1851.springboot.jpa.repository.test1;

import com.soft1851.springboot.jpa.model.cascade.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/13
 */
public interface ClazzRepository extends JpaSpecificationExecutor<Clazz>, JpaRepository<Clazz, Integer> {

    /**
     * 一对多查询
     * @param clazzId
     * @return
     */
    List<Clazz> findByClazzId(Integer clazzId);
}
