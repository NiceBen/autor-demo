package com.ofben.autordemo.test.poker.mock;

/**
 * TODO
 *
 * @date 2021-09-06
 * @since 1.0.0
 */
public class Poker {

    // 类型
    private PokerTypeEnum type;

    // 值
    private PokerValueEnum value;

    // 顺序
    private Integer order;

    public Poker() {
    }

    public Poker(PokerTypeEnum type, PokerValueEnum value, Integer order) {
        this.type = type;
        this.value = value;
        this.order = order;
    }

    public PokerTypeEnum getType() {
        return type;
    }

    public void setType(PokerTypeEnum type) {
        this.type = type;
    }

    public PokerValueEnum getValue() {
        return value;
    }

    public void setValue(PokerValueEnum value) {
        this.value = value;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
