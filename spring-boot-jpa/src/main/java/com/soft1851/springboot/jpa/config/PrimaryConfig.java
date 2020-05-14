package com.soft1851.springboot.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/13
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactoryPrimary",
//        transactionManagerRef="transactionManagerPrimary",
//        //设置dao（repo）所在位置
//        basePackages= { "com.soft1851.springboot.jpa" })
public class PrimaryConfig {
//    @Autowired
//    @Qualifier("primaryDataSource")
//    private DataSource primaryDataSource;
//
//    @Autowired
//    @Qualifier("vendorProperties")
//    private Map<String, Object> vendorProperties;
//
//    @Bean(name = "entityManagerFactoryPrimary")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(primaryDataSource)
//                .properties(vendorProperties)
//                //设置实体类所在位置
//                .packages("com.soft1851.springboot.jpa.model")
//                .persistenceUnit("primaryPersistenceUnit")
//                .build();
//    }
//
//    @Bean(name = "entityManagerPrimary")
//    @Primary
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name = "transactionManagerPrimary")
//    @Primary
//    PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
//    }
}
