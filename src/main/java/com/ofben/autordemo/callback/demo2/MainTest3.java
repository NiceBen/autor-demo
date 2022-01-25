package com.ofben.autordemo.callback.demo2;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class MainTest3 {

    private static Map<Class<? extends EventListener>, ListenerHandler> list = new HashMap<>();

    static class ListenerHandler<T extends EventListener> {

        public boolean supports(Class<T> listenerClass, T listener) {
            return listenerClass.isInstance(listener);
        }

        public void handle(T listener, Consumer<T> consumer) {
            consumer.accept(listener);
        }
    }

    public static void main(String[] args) {

        Set<Map.Entry<Class<? extends EventListener>, ListenerHandler>> entries = list.entrySet();
        entries.forEach(en -> {
            ListenerHandler value = en.getValue();
            Class<? extends EventListener> key = en.getKey();
            EventListener eventListener = null;
            try {
                eventListener = key.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            value.handle(eventListener, lis -> {
                System.out.println("hello ");
            });
        });
    }
}
