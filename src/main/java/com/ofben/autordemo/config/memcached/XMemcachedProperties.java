package com.ofben.autordemo.config.memcached;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * XMemcached 配置属性，读取的是 yml 文件中 spring.memcached 开头的属性
 */
@ConfigurationProperties(prefix = "spring.memcached")
@PropertySource("classpath:application.properties")
@Configuration
@Data
public class XMemcachedProperties {
    /**
     * memcached服务器节点
     */
    private String servers;

    /**
     * nio连接池的数量
     */
    private Integer poolSize;

    /**
     * 设置默认操作超时
     */
    private Long opTimeout;

    /**
     * 是否启用url encode机制
     */
    private Boolean sanitizeKeys;
}
