package com.ofben.autordemo.test.poker.mock;

/**
 * 测试
 *
 * @date 2021-09-06
 * @since 1.0.0
 */
public class MainTest {

    public static void main(String[] args) {
        // 单线程
        testSimpleThread();
        // 多线程
        testMultiThead();
    }

    private static void testSimpleThread() {
        PlayerUtil playerUtil = new PlayerUtil();
        playerUtil.beginGame();
        System.out.println("-----");
        playerUtil.beginGame();
    }

    private static void testMultiThead() {
        try {
            Thread.sleep(10000L);
            for (int i = 0; i < 10000; i++) {
                PlayerUtil playerUtil = new PlayerUtil();
                playerUtil.beginGame();
                System.out.println("-----");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
