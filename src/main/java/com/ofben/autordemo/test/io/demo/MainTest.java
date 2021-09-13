package com.ofben.autordemo.test.io.demo;

import java.util.Scanner;

/**
 * {@link Scanner#hasNextInt()}
 *
 * @date 2021-09-13
 * @since 1.0.0
 */
public class MainTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt())
            System.out.println(scanner.nextInt());
        else if (scanner.hasNextDouble())
            System.out.println(scanner.nextDouble());
        else
            System.out.println("Not a number");
    }
}
