package com.ofben.autordemo.spring.aop.demo9;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Idempotent
    @Override
    public Person getPerson(String name, int age) {
        System.out.println("getPerson:name=" + name + ", age=" + age);
        return new Person(name, age);
    }
}
