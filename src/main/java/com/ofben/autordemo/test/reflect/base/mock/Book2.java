package com.ofben.autordemo.test.reflect.base.mock;

/**
 * Book2
 *
 * @date 2021-09-14
 * @since 1.0.0
 */
public class Book2 {

    String name;

    public int id;

    private float price;

    protected boolean isLoan;

    @Override
    public String toString() {
        return "Book2{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", isLoan=" + isLoan +
                '}';
    }
}
