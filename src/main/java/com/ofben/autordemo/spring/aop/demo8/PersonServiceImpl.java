package com.ofben.autordemo.spring.aop.demo8;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @date 2021-12-13
 * @since TODO
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Person getPerson(String name, int age) {
        return new Person(name, age);
    }
}
