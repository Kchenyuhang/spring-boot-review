package com.soft1851.springboot.task.scheduling.repository;

import com.soft1851.springboot.task.scheduling.model.Coder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/17
 */
public interface CoderRepository extends JpaRepository<Coder, Integer> {
}
