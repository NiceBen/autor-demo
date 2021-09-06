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
public class PokerFaceMapTest {


    private static final String[] arr1 = {"redHeart", "blackHeart", "redCard", "blackCard"};
    private static final String[] arr2 = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    // 定义 Map 集合用来存放索引和牌
    private static final HashMap<Integer, String> pokerMap = new HashMap<>();
    // 定义 List 集合存储索引（索引为 0-53）
    private static final List<Integer> indexList = new ArrayList<>();

    // 定义索引值变量
    private static int index = 0;

    // Three Player
    private static TreeSet<Integer> player1 = new TreeSet<>();
    private static TreeSet<Integer> player2 = new TreeSet<>();
    private static TreeSet<Integer> player3 = new TreeSet<>();
    private static TreeSet<Integer> holeCards = new TreeSet<>();

    @PostConstruct
    public void init() {
        initArrBox();
    }

    public PokerFaceMapTest() {
        initArrBox();
    }

    private static void initArrBox() {
        for (String key : arr2) {
            for (String value : arr1) {
                pokerMap.put(index,  value + "-" + key);
                indexList.add(index);
                index++;
            }
        }
        pokerMap.put(index, "BigJoker");
        indexList.add(index++);
        pokerMap.put(index, "SmallJoker");
        indexList.add(index);
    }

    public static void main(String[] args) {
        initArrBox();
        shuffleAndTakePokers();
        viewPlayerHandPokers();
    }

    private static void viewPlayerHandPokers() {
        pushBoss();
        check(player1, "player1");
        check(player2, "player2");
        check(player3, "player3");
        check(holeCards, "holeCards");
    }

    private static void check(TreeSet<Integer> playerSet, String playerName) {
        // view hand poker
        System.out.print(playerName + ":[");
        for (Integer i : playerSet) {
            System.out.print(pokerMap.get(i) + " ");
        }
        System.out.println("]");
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
        Collections.shuffle(indexList);
        clearPlayerHandPokers();
        // take
        for (int i = 0; i < indexList.size(); i++) {
            if (i >= indexList.size() - 3) {
                holeCards.add(indexList.get(i));
            } else if (i % 3 == 0) {
                player1.add(indexList.get(i));
            } else if (i % 3 == 1) {
                player2.add(indexList.get(i));
            } else {
                player3.add(indexList.get(i));
            }
        }
    }

    private static void clearPlayerHandPokers() {
        player1.clear();
        player2.clear();
        player3.clear();
    }
}
