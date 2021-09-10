package com.ofben.autordemo.test.io.object;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * {@link ObjectInputStream}
 * {@link ObjectOutputStream}
 *
 * {@link FileInputStream}
 * {@link FileOutputStream}
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public class ObjectStreamTest {

    public static void main(String[] args) {
        String pathname = "e:/myJava/user.txt";
        List<User> users = initUsers();

        try (FileOutputStream fos = new FileOutputStream(pathname);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream(pathname);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // output
            for (User user : users) {
                oos.writeObject(user);
            }
            oos.flush();

            // input
            User user1 = (User) ois.readObject();
            User user2 = (User) ois.readObject();
            User user3 = (User) ois.readObject();

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<User> initUsers() {
        User user1 = new User(1L, "user1", GenderEnum.MALE, "北京");
        User user2 = new User(2L, "user2", GenderEnum.FEMALE, "上海");
        User user3 = new User(3L, "user3", GenderEnum.FEMALE, "杭州");
        return Arrays.asList(user1, user2, user3);
    }
}
