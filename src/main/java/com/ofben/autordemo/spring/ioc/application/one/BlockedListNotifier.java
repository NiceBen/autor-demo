package com.ofben.autordemo.spring.ioc.application.one;

import org.springframework.context.ApplicationListener;

/**
 * {@link ApplicationListener}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {

    @Override
    public void onApplicationEvent(BlockedListEvent event) {
        String address = event.getAddress();
        String content = event.getContent();
        System.out.println("address:" + address);
        System.out.println("content:" + content);
    }
}
