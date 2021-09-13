package com.ofben.autordemo.test.io.manage.strategy1;

import com.ofben.autordemo.test.io.manage.mock.Book;

import java.io.*;
import java.util.List;

/**
 * {@link Book}
 * {@link FileWriter}
 * {@link BufferedWriter}
 * {@link FileReader}
 * {@link BufferedReader}
 *
 * @date 2021-09-13
 * @since 1.0.0
 */
public class BookStringRepositoryManagement {

    public static void main(String[] args) {
        List<Book> books = Book.initBooks();

        write(books);
        System.out.println("********************图书信息******************");
        read();
    }

    private static String pathname = "E:/myJava/book.txt";
    public static void write(List<Book> books) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(pathname);
            bw = new BufferedWriter(fw);
            for (Book book : books) {
                bw.write(book.toString());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void read() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(pathname);
            br = new BufferedReader(fr);
            String read;
            while ((read = br.readLine()) != null) {
                System.out.println(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
