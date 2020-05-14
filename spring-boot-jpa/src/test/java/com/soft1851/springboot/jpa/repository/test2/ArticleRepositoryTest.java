package com.soft1851.springboot.jpa.repository.test2;

import com.soft1851.springboot.jpa.model.cascade.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/5/14
 */
@SpringBootTest
@Slf4j
class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void testManyToOne() {
        Optional<Article> article = articleRepository.findById(1L);
        System.out.println(article);
    }

}