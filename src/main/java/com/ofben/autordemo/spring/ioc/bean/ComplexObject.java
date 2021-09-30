package com.ofben.autordemo.spring.ioc.bean;

import java.util.Properties;

/**
 * 父集合
 *
 * @date 2021-09-24
 * @since 1.0.0
 */
public class ComplexObject {

    private Properties adminEmails;

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public Properties getAdminEmails() {
        return adminEmails;
    }
}
