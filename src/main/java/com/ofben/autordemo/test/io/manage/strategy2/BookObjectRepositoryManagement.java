package com.ofben.autordemo.test.io.manage.strategy2;

import com.ofben.autordemo.test.io.manage.mock.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link FileOutputStream}
 * {@link ObjectOutputStream}
 *
 * {@link FileInputStream}
 * {@link ObjectInputStream}
 *
 * @date 2021-09-13
 * @since 1.0.0
 */
public class BookObjectRepositoryManagement {
    public static String pathname = "e:/myJava/books2.txt";

    public static void main(String[] args) {
        List<Book> books = Book.initBooks();

        write(books);
        System.out.println("********************图书信息******************");
        read();
    }

    public static void write(List<Book> books) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(pathname);
            oos = new ObjectOutputStream(fos);

            for (Book book : books) {
                oos.writeObject(book);
            }
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Book> books = new ArrayList<>();

        try {
            fis = new FileInputStream(pathname);
            ois = new ObjectInputStream(fis);
            Object obj;
            try {
                while ((obj = ois.readObject()) != null) {
                    if (obj instanceof Book) {
                        Book book = (Book) obj;
                        books.add(book);
                    }
                }
            } catch (EOFException e) {
                System.out.println("catch EOFException！");
            }
            books.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
