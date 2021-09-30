package com.ofben.autordemo.spring.ioc.application.two;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * {@link ApplicationListener}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class BlockedListNotifier {

    @EventListener
    @Async
    @Order(41)
    public BlockedListEvent2 onApplicationEvent(BlockedListEvent event) {
        String address = event.getAddress();
        String content = event.getContent();
        System.out.println("address:" + address);
        System.out.println("content:" + content);
        BlockedListEvent2 event2 = new BlockedListEvent2(this, "wel", "come");
        return event2;
    }

    @EventListener
    @Async
    @Order(42)
    public EntityCreatedEvent<Person> onApplicationEvent2(BlockedListEvent2 event) {
        String address = event.getAddress();
        String content = event.getContent();
        System.out.println("address2222:" + address);
        System.out.println("content222:" + content);
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        EntityCreatedEvent<Person> entity = new EntityCreatedEvent<>(this, person);
        return entity;
    }

    @EventListener
    public EntityCreatedEvent<Cat> onPersonCreated(EntityCreatedEvent<Person> event) {
        Person person = event.getT();
        System.out.println(person.getName() + ", " + person.getAge());
        // ...
        Cat cat = new Cat();
        cat.setType("flower");
        cat.setColor("red");
        EntityCreatedEvent<Cat> entity = new EntityCreatedEvent<>(this, cat);
        return entity;
    }


    @EventListener
    public void onPersonCreated2(EntityCreatedEvent<Cat> event) {
        Cat cat = event.getT();
        System.out.println(cat.getType() + ", " + cat.getColor());
    }
}
