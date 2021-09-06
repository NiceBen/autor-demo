package com.ofben.autordemo.test.poker.mock;

/**
 * 类型
 *
 * @date 2021-09-06
 * @since 1.0.0
 */
public enum PokerTypeEnum {
    
    red_Heart("红桃"),
    black_Heart("黑桃"),
    red_Card("方片"),
    black_Card("梅花"),
    big_Joker("大王"),
    small_Joker("小王");

    private String type;

    PokerTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
