package com.ofben.autordemo.spring.annotation.cacheable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test
 *
 * @date 2021-10-29
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class MainTest {

    @GetMapping("/test")
    @PermissionCheck(resourceKey = "test")
    public Object testPermissionCheck() {
        return "hello world";
    }
}
