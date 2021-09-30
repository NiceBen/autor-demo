package com.ofben.autordemo.spring.ioc.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 样例Bean
 *
 * @date 2021-09-24
 * @since 1.0.0
 */
public class DemoBean {

    private Properties properties;

    private List<Object> list;

    private Map<String, Object> map;

    private Set<Object> set;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }
}
