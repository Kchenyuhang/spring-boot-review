package com.soft1851.springboot.jpa.repository.test2;

import com.soft1851.springboot.jpa.model.cascade.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/14
 */
public interface ArticleRepository extends JpaSpecificationExecutor<Article>, JpaRepository<Article, Long> {

}
