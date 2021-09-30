package com.ofben.autordemo.spring.ioc.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * {@link Profile}
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
@Configuration
@Profile("dev")
public class StandaloneDataConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:/com/bank/config/sql/schema.sql")
                .addScript("classpath:/com/bank/config/sql/test-data.sql")
                .build();
    }
}
