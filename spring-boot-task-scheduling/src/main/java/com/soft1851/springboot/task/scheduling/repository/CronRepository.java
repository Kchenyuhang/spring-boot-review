package com.soft1851.springboot.task.scheduling.repository;

import com.soft1851.springboot.task.scheduling.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

//

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/15
 */
public interface CronRepository extends JpaRepository<Cron,Integer> {
    /**
     * 根据cronId查询cron
     * @param cronId
     * @return cron
     */
    Cron findCronByCronIdEquals(Integer cronId);

    /**
     * 根据id修改cron
     * @param cron
     * @param id
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update Cron set cron = ?1 where cron_id = ?2 ", nativeQuery = true)
    void updateCron(String cron, Integer id);
}
