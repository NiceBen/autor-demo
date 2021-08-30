package com.ofben.autordemo.transaction;

import com.ofben.autordemo.actor.invoke.target.web.mock.service.GoodsService;
import com.ofben.autordemo.consistence.service.StoreService;
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
public class TransactionTest2 {

    @Autowired
    private StoreService ss;

    @Autowired
    private GoodsService gs;

    public void testAdd() {

        // 添加 绑定了 DataSource1 的服务
//        ss.add();

        // 添加 绑定了 DataSource2 的服务
//        gs.add();

//        int i = 5/0;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml", "applicationContext-tx.xml");

        TransactionTest2 test = (TransactionTest2) ctx.getBean("transactionTest1");

        test.testAdd();
    }




}
