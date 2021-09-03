package com.ofben.autordemo.test.enums;

import java.util.EnumMap;

/**
 * {@link EnumMap} Test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class EnumMapTest {

    // 定义数据库类型枚举
    public enum DataBaseType {
        MYSQL,ORACLE,DB2,SQLSERVER
    }

    // 某类中定义的获取数据库URL的方法以及EnumMap的声明
    private EnumMap<DataBaseType, String> urls = new EnumMap<>(DataBaseType.class);

    public EnumMapTest() {
        urls.put(DataBaseType.DB2, "jdbc:db2://localhost:5000/sample");
        urls.put(DataBaseType.MYSQL, "jdbc:mysql://localhost:5000/sample");
        urls.put(DataBaseType.ORACLE, "jdbc:oracle://localhost:5000/sample");
        urls.put(DataBaseType.SQLSERVER, "jdbc:sqlserver://localhost:5000/sample");
    }

    //根据不同的数据库类型，返回对应的URL
    // @param type DataBaseType 枚举类新实例
    // @return
    public String getURL(DataBaseType type) {
        return this.urls.get(type);
    }
}
