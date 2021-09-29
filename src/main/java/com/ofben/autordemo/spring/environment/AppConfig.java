package com.ofben.autordemo.spring.environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * {@link Profile}
 * {@link Production}
 * {@link Development}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
public class AppConfig {

    @Bean
    @Development
    public DataSource standaloneDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:com/bank/config/sql/schema.sql")
                .addScript("classpath:com/bank/config/sql/test-data.sql")
                .build();
    }

    @Bean
    @Production
    public DataSource jndiDataSource() throws Exception {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
    }

    public static void main(String[] args) {
        //1、因为配置类，需重新指定模式(开发或是生产等)，所以在新建annotation时，不用加载配置类。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //2、使用Environment来指定当前运行的模式，指定的值必须和@Profile注解中自定义的值匹配。否则都不执行。
        context.getEnvironment().setActiveProfiles("development");
        //3、指定模式后，再注册Bean
        context.register(AppConfig.class);
        //4、刷新容器，注册生效。
        context.refresh();

        DataSource bean = context.getBean(DataSource.class);
        System.out.println(bean);
    }
}
