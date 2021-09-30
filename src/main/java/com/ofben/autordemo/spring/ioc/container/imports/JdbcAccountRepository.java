package com.ofben.autordemo.spring.ioc.container.imports;

import javax.sql.DataSource;

/**
 * Bean
 *
 * @date 2021-09-29
 * @since 1.0.0
 */
public class JdbcAccountRepository implements AccountRepository {

    private DataSource dataSource;

    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
