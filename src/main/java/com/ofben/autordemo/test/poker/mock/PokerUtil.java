package com.ofben.autordemo.test.poker.mock;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成 poker
 *
 * @date 2021-09-06
 * @since 1.0.0
 */
public class PokerUtil {

    private static List<Poker> pokers = new ArrayList<>();

    public static void main(String[] args) {
        initPokers();
        System.out.println(pokers.size());
    }

    public synchronized static List<Poker> getPokers() {
        if (CollectionUtils.isEmpty(pokers)) {
            initPokers();
        }

        // 返回一个深拷贝的List
        List<Poker> newPokers = new ArrayList<>();
        BeanUtils.copyListProperties(pokers, newPokers, Poker.class, Poker.class);
        return newPokers;
    }

    private static void initPokers() {
        PokerTypeEnum[] types = PokerTypeEnum.values();
        PokerValueEnum[] values = PokerValueEnum.values();

        // add common cards
        int pokerIndex = 1;
        for (PokerValueEnum valueEnum : values) {
            if (PokerValueEnum.value_0 != valueEnum) {
                for (PokerTypeEnum typeEnum : types) {
                    if (PokerTypeEnum.big_Joker != typeEnum && PokerTypeEnum.small_Joker != typeEnum) {
                        Poker poker = new Poker();
                        poker.setType(typeEnum);
                        poker.setValue(valueEnum);
                        poker.setOrder(pokerIndex++);
                        pokers.add(poker);
                    }
                }
            }
        }
        // add Jokers
        pokers.add(new Poker(PokerTypeEnum.big_Joker, PokerValueEnum.value_0, pokerIndex++));
        pokers.add(new Poker(PokerTypeEnum.small_Joker, PokerValueEnum.value_0, pokerIndex));
    }
}
