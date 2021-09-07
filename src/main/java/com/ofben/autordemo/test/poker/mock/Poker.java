package com.ofben.autordemo.test.poker.mock;

/**
 * Poker 实体类
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

    public Poker setType(PokerTypeEnum type) {
        this.type = type;
        return this;
    }

    public PokerValueEnum getValue() {
        return value;
    }

    public Poker setValue(PokerValueEnum value) {
        this.value = value;
        return this;
    }

    public Integer getOrder() {
        return order;
    }

    public Poker setOrder(Integer order) {
        this.order = order;
        return this;
    }
}
