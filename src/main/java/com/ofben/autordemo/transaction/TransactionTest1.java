package com.ofben.autordemo.transaction;

import com.ofben.autordemo.consistence.test.MyTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * 测试操作两个 DataSource
 *
 * @date 2021-08-17
 * @since 1.0.0
 */
@Slf4j
@Service
public class TransactionTest1 {

    @Autowired
    @Qualifier("jtaDatasource1")
    private DataSource ds1;

    @Autowired
    @Qualifier("jtaDatasource2")
    private DataSource ds2;

    public void testAdd() {
        JdbcTemplate jt1 = new JdbcTemplate(ds1);
        JdbcTemplate jt2 = new JdbcTemplate(ds2);

        List<Map<String, Object>> list = jt1.queryForList("SELECT * FROM tb1_store");
        log.info("list===={}", list);

        jt1.execute("INSERT INTO tb1_store VALUES(8,8,8)");

        jt2.execute("INSERT INTO tb1_store VALUES(8,8,8)");

        int i = 5/0;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml", "applicationContext-tx.xml");

        TransactionTest1 test = (TransactionTest1) ctx.getBean("transactionTest1");

        test.testAdd();
    }




}
