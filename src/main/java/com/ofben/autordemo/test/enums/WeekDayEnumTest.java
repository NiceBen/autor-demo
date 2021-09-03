package com.ofben.autordemo.test.enums;

/**
 * {@link WeekDayEnum} Test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class WeekDayEnumTest {

    public static void main(String[] args) {
        for (WeekDayEnum day : WeekDayEnum.values()) {
            System.out.println(day + "===>" + day.getDay());
        }
        WeekDayEnum.printDay(5);
    }
}
