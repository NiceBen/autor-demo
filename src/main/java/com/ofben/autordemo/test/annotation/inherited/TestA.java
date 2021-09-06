package com.ofben.autordemo.test.annotation.inherited;

/**
 * {@link MyInherited} test
 *
 * @date 2021-09-03
 * @since 1.0.0
 */
@MyInherited
public class TestA {

    public static void main(String[] args) {
        System.out.println(TestA.class.getAnnotation(MyInherited.class));
        System.out.println(TestB.class.getAnnotation(MyInherited.class));
        System.out.println(TestC.class.getAnnotation(MyInherited.class));
    }
}

class TestB extends TestA {

}

class TestC extends TestA {

}