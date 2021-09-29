package com.ofben.autordemo.spring.container.imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Named;
import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    private final DataSource dataSource;

    public RepositoryConfig(@Named("myDateSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepository(dataSource);
    }
}