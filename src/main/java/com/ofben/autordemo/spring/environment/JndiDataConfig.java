package com.ofben.autordemo.spring.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * {@link Profile}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
@Profile("prod")
public class JndiDataConfig {

    @Bean
    public DataSource dataSource() throws NamingException {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
    }
}
