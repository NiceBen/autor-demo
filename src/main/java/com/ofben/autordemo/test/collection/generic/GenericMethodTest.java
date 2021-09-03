package com.ofben.autordemo.test.collection.generic;

/**
 * 泛型方法 Test
 *
 * @author SL Zhou
 * @date 2021-09-03
 * @since 1.0.0
 */
public class GenericMethodTest {

    public static void main(String[] args) {
        Book<Integer, String, Integer> book = new Book<>(1, "Think In Java", 55);
        show(book);
    }

    // 定义泛型方法
    public static <T> void show(T t) {
        if (t != null) {
            System.out.println(t);
        }
    }

    public static <T, R> R find(T t, R r, int age) {
        if (t != null) {
            System.out.println(t);
        }
        return r;
    }

}

class Book<I, N, P> {
    private I id;
    private N name;
    private P price;

    public Book(I id, N name, P price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
