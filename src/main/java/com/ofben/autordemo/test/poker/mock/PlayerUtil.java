package com.ofben.autordemo.test.poker.mock;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 玩家工具类
 *
 * @date 2021-09-06
 * @since 1.0.0
 */
public class PlayerUtil {

    private List<Poker> privatePoker;

    private List<Poker> player1 = new ArrayList<>();
    private List<Poker> player2 = new ArrayList<>();
    private List<Poker> player3 = new ArrayList<>();
    private List<Poker> holeCards = new ArrayList<>();

    // 创建一个比较器
    private static Comparator<Poker> comparator = Comparator.comparing(Poker::getOrder);

    public void beginGame() {
        shuffleAndTakePokers();
        viewPlayerHandPokers();
    }

    private void viewPlayerHandPokers() {
        pushBoss();
        check(player1, "player1");
        check(player2, "player2");
        check(player3, "player3");
        check(holeCards, "holeCards");
    }

    private void check(List<Poker> playerPokers, String playerName) {
        // view hand poker
        System.out.print(playerName + ": [");
        playerPokers.stream().sorted(comparator).forEach(poker -> System.out.print(poker.getType().getType() + poker.getValue().getValue() + "\t"));
        System.out.println("]");
    }

    private void pushBoss() {
        List<String> playerNames = Arrays.asList("player1", "player2", "player3");
        Random r = new Random();
        int bossIndex = r.nextInt(3);
        String boss = playerNames.get(bossIndex);
        System.out.println("此局地主是: " + boss);
    }

    private void shuffleAndTakePokers() {
        privatePoker = CollectionUtils.isEmpty(privatePoker)?PokerUtil.getPokers():privatePoker;
        // shuffle
        Collections.shuffle(privatePoker);
        clearPlayerHandPokers();
        // take
        for (int i = 0; i < privatePoker.size(); i++) {
            if (i >= privatePoker.size() - 3) {
                holeCards.add(privatePoker.get(i));
            } else if (i % 3 == 0) {
                player1.add(privatePoker.get(i));
            } else if (i % 3 == 2) {
                player2.add(privatePoker.get(i));
            } else {
                player3.add(privatePoker.get(i));
            }
        }
    }

    private void clearPlayerHandPokers() {
        player1.clear();
        player2.clear();
        player3.clear();
        holeCards.clear();
    }
}
