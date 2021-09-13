package com.ofben.autordemo.test.io.manage.mock;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * book
 *
 * @date 2021-09-10
 * @since 1.0.0
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 6462220978431439052L;
    /*
    http://c.biancheng.net/view/1153.html
     */

    // 编号
    private Integer no;

    // 书名
    private String name;

    // 价格
    private Double price;

    public Book(Integer no, String name, Double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static List<Book> initBooks() {
        Book book1 = new Book(1, "book name 1", 11.88);
        Book book2 = new Book(2, "book name 2", 12.88);
        Book book3 = new Book(3, "book name 3", 13.88);
        Book book4 = new Book(4, "book name 4", 14.88);
        Book book5 = new Book(5, "book name 5", 15.88);
        return Arrays.asList(book1, book2, book3, book4, book5);
    }
}
