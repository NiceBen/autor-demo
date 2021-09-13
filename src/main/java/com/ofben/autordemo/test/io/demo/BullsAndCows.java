package com.ofben.autordemo.test.io.demo;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * {@link Properties}
 *
 * 猜数字是一个经典的小游戏，程序先产生一个随机数，然后用户输入数字，程序将输入的数字与随机数进行对比，给出用户相应的提示信息。
 * 本节实现了一个基于 IO 流的猜数字游戏，游戏中限制玩家游戏次数，游戏试玩为 5 次，超过 5 次后，则提示玩家试玩结束，请付费。具体实现步骤和代码如下：
 * 创建 count.txt 文件，存储游戏次数，文件内容如下：count=0
 * 创建 way.txt 文件，存储支付状态（1 为已付费，0 为未付费），文件内容如下：way=0
 *
 * @date 2021-09-13
 * @since 1.0.0
 */
public class BullsAndCows {

    // 磁盘文件存储地址
    private static String countFilePathname = "e:" + File.separator + "myJava" + File.separator + "count.txt";
    private static String wayFilePathname = "e:" + File.separator + "myJava" + File.separator + "way.txt";

    public static void main(String[] args) {
        userPlayGame();
        // 可以通过传入用户识别符，来区分多用户下进行游戏，项目需要进行调整，文件加锁，以及判断用户对应的参数进行修改
        // userPlayGame("用户识别符");
    }

    /**
     * 用户开始游戏
     */
    private static void userPlayGame() {
        init();
        while (true) {
            // free count
            int count = getCount();
            // is pay
            boolean flag = getCondition();

            if (flag) {
                System.out.println("游戏已经付费，游戏次数已解封!");
                playGame();
            } else {
                if (count >= 5) {
                    System.out.println("试玩已经结束，请付费！");
                    payMoney();
                } else {
                    System.out.println("这是第 " + ++count + " 次试玩!");
                    playGame();
                    writeCount();
                }
            }
        }
    }

    /**
     * 初始化方法
     */
    private static void init() {
        mkdir();
        // 创建 Properties 对象
        Properties prop = new Properties();
        try (FileWriter countFw = new FileWriter(countFilePathname);
             FileWriter wayFw = new FileWriter(wayFilePathname)) {
            prop.setProperty("count", "0");
            prop.store(countFw, null);
            prop.clear();
            prop.setProperty("way", "0");
            prop.store(wayFw, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建外层文件夹
     */
    private static void mkdir() {
        String countFileDirectoryPath = countFilePathname.substring(0, countFilePathname.lastIndexOf(File.separator) + 1);
        String wayFileDirectoryPath = wayFilePathname.substring(0, wayFilePathname.lastIndexOf(File.separator) + 1);
        File countDirectoryFile = new File(countFileDirectoryPath);
        File wayDirectoryFile = new File(wayFileDirectoryPath);
        if (!countDirectoryFile.exists()) {
            if (!countDirectoryFile.mkdirs()) {
                throw new RuntimeException("创建 count.txt 外层文件夹失败！");
            }
        }
        if (!wayDirectoryFile.exists()) {
            if (!wayDirectoryFile.mkdirs()) {
                throw new RuntimeException("创建 way.txt 外层文件夹失败！");
            }
        }
    }

    /**
     * 获取已经玩过的次数
     * @return  文件中的游戏次数
     */
    private static int getCount() {
        // 创建 Properties 对象
        Properties prop = new Properties();
        // 使用 FileReader 对象获取 count 文件中的游戏次数
        int tempCount = 0;

        try (FileReader fileReader = new FileReader(countFilePathname)) {
            prop.load(fileReader);
            String count = prop.getProperty("count");
            tempCount = Integer.parseInt(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempCount;
    }

    /**
     * 支付方法，支付成功则把支付状态改为“1”并存到数据库，之后可以无限次玩游戏
     */
    private static void payMoney() {
        System.out.println("please pay 5 dollar!");
        // 获取键盘录入数据
        Scanner in = new Scanner(System.in);
        // 捕获输入错误情况
        int nextInt = matchIntFigure(in);
        if (nextInt == 5) {
            // 创建 Properties 对象
            Properties prop = new Properties();
            prop.setProperty("way", "1");
            // 使用 FileWriter 类，将支付状态写入到 way 文件
            try (FileWriter fw = new FileWriter(wayFilePathname)) {
                prop.store(fw, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("付费失败，输入数字“5”，完成付费!");
        }
    }

    /**
     * 用来获取每次启动时的付费状态
     * @return 付费状态
     */
    private static boolean getCondition() {
        // 创建 Properties 对象
        Properties prop = new Properties();
        try (FileReader fr = new FileReader(wayFilePathname)) {
            prop.load(fr);
            String way = prop.getProperty("way");
            int parseInt = Integer.parseInt(way);
            if (parseInt == 1) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将试玩的次数写入文档并保存
     */
    private static void writeCount() {
        // 创建 Properties 对象
        Properties prop = new Properties();
        // 获取当前试玩次数
        int count = getCount();
        prop.setProperty("count", String.valueOf(++count));
        try (FileWriter fw = new FileWriter(countFilePathname)) {
            prop.store(fw, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现游戏产生数字，获取玩家所猜数字等， 并对玩家每次输入，都会有相应的提示
     */
    private static void playGame() {
        // 产生随机数 1~100
        int random = (int) (Math.random() * 100 + 1);
        // 获取键盘录入数据
        Scanner in = new Scanner(System.in);
        System.out.println("欢迎开始 \"猜数字\" 游戏!");
        while (true) {
            System.out.println("请输入你猜的数字:");
            int guess = matchIntFigure(in);
            if (guess > random) {
                System.out.println("猜大了!");
            } else if (guess < random) {
                System.out.println("猜小了!");
            } else {
                System.out.println("恭喜你, 猜对了!");
                break;
            }
        }
    }

    /**
     * 匹配数字
     * @param in        键盘输入
     * @return          输入的数字
     */
    private static int matchIntFigure(Scanner in) {
        while (true) {
            if (in.hasNextInt()) {
                return in.nextInt();
            } else {
                System.out.println("输入类型错误，请重新输入数字：");
                // 解决循环中使用 in.nextInt() 的无限循环问题
                in.next();
            }
        }
    }
}
