package com.ofben.autordemo.test.collection.collections;

import lombok.Data;

import java.util.*;

/**
 * {@link Collections} Test
 *
 * @date 2021-09-03
 * @see Collections
 * @since 1.0.0
 */
public class CollectionsTest {

    public static void main(String[] args) {
//        testCollectionsSort();

//        testCollectionsFill();

//        testCollectionsIndexOfSubList();

//        testCollectionsCopyOfString();

        testCollectionsCopyOfModel();

    }

    /**
     * 浅拷贝
     */
    private static void testCollectionsCopyOfModel() {
        List<User> sourceUsers = new ArrayList<>();
        sourceUsers.add(new User("user1"));
        sourceUsers.add(new User("user2"));
        sourceUsers.add(new User("user3"));
        sourceUsers.forEach(user -> System.out.print(user.getName() + "\t"));
        System.out.println("\n-----------------");
        List<User> targetUsers = Arrays.asList(new User[sourceUsers.size()]);
        Collections.copy(targetUsers, sourceUsers);
        targetUsers.forEach(user -> System.out.print(user.getName() + "\t"));
        System.out.println("\n-----------------");
        User getUser = targetUsers.get(2);
        getUser.setName("hello");
        targetUsers.forEach(user -> System.out.print(user.getName() + "\t"));
        System.out.println("\n-----------------");
        sourceUsers.forEach(user -> System.out.print(user.getName() + "\t"));
    }

    /**
     * 字符串相当于新创建了一个对象，不影响
     */
    private static void testCollectionsCopyOfString() {
        List<String> sourceList = new ArrayList<>();
        sourceList.add("a1");
        sourceList.add("a2");
        sourceList.add("a3");
        sourceList.forEach(System.out::println);
        System.out.println("-------------");
        List<String> targetList = Arrays.asList(new String[sourceList.size()]);
        Collections.copy(targetList, sourceList);
        targetList.forEach(System.out::println);
        System.out.println("-------------");
        targetList.set(1, "a22");
        System.out.println("targetList:");
        targetList.forEach(System.out::println);
        System.out.println("sourceList:");
        sourceList.forEach(System.out::println);
    }


    private static void testCollectionsIndexOfSubList() {
        List<String> subList = new ArrayList<>();
        subList.add("hello");
        subList.add("world");
        subList.add("welcome");

        List<String> rootList = new ArrayList<>();
        rootList.add("www");
        rootList.add("hello");
        rootList.add("world");
        rootList.add("welcome");
        rootList.add("xxx");

        int result = Collections.indexOfSubList(rootList, subList);
        System.out.println(result);
    }

    private static void testCollectionsFill() {
        List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("world");
        strList.add("welcome");

        strList.forEach(System.out::println);

        System.out.println("------------");

        Collections.fill(strList, "nihao");

        strList.forEach(System.out::println);
    }

    private static void testCollectionsSort() {
        Scanner input = new Scanner(System.in);
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + " 个商品的价格：");
            int p = input.nextInt();
            prices.add(p);
        }
        Collections.sort(prices);
        System.out.println("物价从低到高的排列为：");
        prices.forEach(System.out::println);
    }
}

class User {
    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

