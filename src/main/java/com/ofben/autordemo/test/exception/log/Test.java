package com.ofben.autordemo.test.exception.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static Logger log = LoggerFactory.getLogger(Test.class.toString());
    public static void main(String[] args) {
        // 级别依次升高，后面的日志级别会屏蔽之前的级别
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        boolean debugEnabled = log.isDebugEnabled();
        System.out.println(debugEnabled);
        System.out.println(log.getName());
    }
}