package com.ofben.autordemo.test.poker;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * poker implement
 *
 * 准备牌：Arrylist 集合储存，for 循环遍历实现
 * 洗牌：使用 Collections 的shuffle(arryBox);方法刷新集合中的顺序
 * 发牌：使用 for 循环遍历 Arrylist 中的 51 张牌，然后用索引值对 3 取余，余数为 0，1，2 然后来随机分配牌。
 * 看牌：直接输出集合
 *
 * @date 2021-09-06
 * @since 1.0.0
 */
public class PokerFaceListTest {

    private static final String[] arr1 = {"redHeart", "blackHeart", "redCard", "blackCard"};
    private static final String[] arr2 = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final List<String> arrBox = new ArrayList<>();

    // Three Player
    private static List<String> player1 = new ArrayList<>();
    private static List<String> player2 = new ArrayList<>();
    private static List<String> player3 = new ArrayList<>();

    @PostConstruct
    public void init() {
        initArrBox();
    }

    public PokerFaceListTest() {
        initArrBox();
    }

    private static void initArrBox() {
        for (String key : arr1) {
            for (String value : arr2) {
                arrBox.add(key + "-" + value);
            }
        }
        arrBox.add("BigJoker");
        arrBox.add("SmallJoker");
    }

    public static void main(String[] args) {
        initArrBox();
        shuffleAndTakePokers();
        viewPlayerHandPokers();
    }

    private static void viewPlayerHandPokers() {
        pushBoss();
        System.out.println("player1:" + player1);
        System.out.println("player2:" + player2);
        System.out.println("player3:" + player3);
        Collections.reverse(arrBox);
        List<String> HoleCards = arrBox.stream().limit(3).collect(Collectors.toList());
        System.out.println("底牌：[" + HoleCards + "]");
    }

    private static void pushBoss() {
        List<String> players = Arrays.asList("player1", "player2", "player3");
        Random r = new Random();
        int bossIndex = r.nextInt(3);
        String boss = players.get(bossIndex);
        System.out.println("this play game boss is " + boss);
    }

    private static void shuffleAndTakePokers() {
        // shuffle
        Collections.shuffle(arrBox);
        clearPlayerHandPokers();
        // take
        for (int i = 0; i < arrBox.size() - 3; i++) {
            if (i % 3 == 0) {
                player1.add(arrBox.get(i));
            } else if (i % 3 == 1) {
                player2.add(arrBox.get(i));
            } else {
                player3.add(arrBox.get(i));
            }
        }
    }

    private static void clearPlayerHandPokers() {
        player1.clear();
        player2.clear();
        player3.clear();
    }
}
