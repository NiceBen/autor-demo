package com.ofben.autordemo.eventbus.util;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executor;

/**
 * 事件总线-工具类
 *
 * @date 2021-09-22
 * @since 1.0.0
 */
public class EventBusUtil {
    private static EventBus eventBus;
    private static AsyncEventBus asyncEventBus;
//    private static Executor executor = Executors.newSingleThreadExecutor();
    private static Executor executor = command -> new Thread(command).start();

    private static EventBus getEventBus() {
        if (eventBus == null) {
            synchronized (EventBus.class) {
                if (eventBus == null) {
                    eventBus = new EventBus();
                }
            }
        }
        return eventBus;
    }

    private static AsyncEventBus getAsyncEventBus() {
        if (asyncEventBus == null) {
            synchronized (AsyncEventBus.class) {
                if (asyncEventBus == null) {
                    asyncEventBus = new AsyncEventBus(executor);
                }
            }
        }
        return asyncEventBus;
    }

    public static void post(Object event) {
        getEventBus().post(event);
    }

    public static void asyncPost(Object event) {
        getAsyncEventBus().post(event);
    }

    public static void register(Object listener) {
        getEventBus().register(listener);
        getAsyncEventBus().register(listener);
    }
}
