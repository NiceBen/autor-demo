package com.ofben.autordemo.test.poker.mock;

/**
 * TODO
 *
 * @date 2021-09-06
 * @since 1.0.0
 */
public enum PokerValueEnum {

    value_0(""),
    value_1("A"),
    value_2("2"),
    value_3("3"),
    value_4("4"),
    value_5("5"),
    value_6("6"),
    value_7("7"),
    value_8("8"),
    value_9("9"),
    value_10("10"),
    value_11("J"),
    value_12("Q"),
    value_13("K");

    private String value;

    PokerValueEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
