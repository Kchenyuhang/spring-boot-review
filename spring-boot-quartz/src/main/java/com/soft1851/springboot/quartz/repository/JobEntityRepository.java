package com.soft1851.springboot.quartz.repository;


import com.soft1851.springboot.quartz.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: yhChen
 * @Date: 2020/5/18
 * @Description: Job实体接口
 */
public interface JobEntityRepository extends JpaRepository<JobEntity, Integer> {

    /**
     * 根据id获取Job
     *
     * @param id
     * @return
     */
    JobEntity getById(Integer id);

}