package com.ofben.autordemo.test.reflect.base.mock;

/**
 * Book
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class Book {

    private int id;

    private String name;

    private int price;

    private Book() {
    }

    protected Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String... strings) throws NumberFormatException {
        if (0 < strings.length) {
            id = Integer.parseInt(strings[0]);
        }
        if (1 < strings.length) {
            price = Integer.parseInt(strings[1]);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
