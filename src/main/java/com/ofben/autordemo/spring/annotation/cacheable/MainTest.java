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
@RequestMapping("/api")
@RestController
public class MainTest {

    @GetMapping("/api/cache")
    @CustomCache(key = "test")
    public Object testCustomCache() {
        return "don't hit cache";
    }
}
