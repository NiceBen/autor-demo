package com.ofben.autordemo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Shiro Config 配置类
 *
 * @author SL Zhou
 * @date 2021-08-16
 * @since 1.0.0
 */
@Configuration
public class ShiroConfig {

    //将自己的验证方式加入容器
//    @Bean
//    public CustomRealm myShiroRealm() {
//        CustomRealm customRealm = new CustomRealm();
//        return customRealm;
//    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //以下注释部分，还可以将配置定义到yaml中
        Map<String, String> map = new HashMap<>();

        //表示可以匿名访问
        map.put("/login","anon"); //详细规则请见本目录下URL匹配规则.md文件
        //表示可以匿名访问
        map.put("/checkLogin","anon"); //详细规则请见本目录下URL匹配规则.md文件
        //登出
        map.put("/logout", "logout");
        //对所有用户认证
        map.put("/**", "authc");//authc表示需要认证才可以访问,anon表示可以匿名访问

        //登录
        shiroFilterFactoryBean.setLoginUrl("/login");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}
