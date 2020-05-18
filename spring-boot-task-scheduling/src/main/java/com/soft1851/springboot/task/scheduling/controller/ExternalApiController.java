package com.soft1851.springboot.task.scheduling.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yhChen
 * @Description 外部接口的 URL 路径以 /external/ 作为前缀
 * @Date 2020/5/18
 */
@RestController
public class ExternalApiController {
    @GetMapping("/external/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello stranger");
    }
}
