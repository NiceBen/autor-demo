package com.ofben.autordemo.test.enums;

/**
 * {@link Enum} Test
 *
 * @date 2021-09-03
 * @since 1.0.0
 */
public class ColorEnumTest {

    public enum ColorEnum {
        RED("红色", 1), GREEN("绿色", 2), WHITE("白色", 3), YELLOW("黄色", 4);

        // 成员变量
        private String name;
        private int index;

        // 构造方法
        ColorEnum(String name, int index) {
            this.name = name;
            this.index = index;
        }

        // 覆盖方法
        @Override
        public String toString() {
            return this.index + "-" + this.name;
        }
    }

    public static void main(String[] args) {
        System.out.println(ColorEnum.RED.toString());
    }
}
