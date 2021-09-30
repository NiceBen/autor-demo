package com.ofben.autordemo.spring.ioc.application.two;

import org.springframework.context.ApplicationEvent;

/**
 * {@link ApplicationEvent}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class BlockedListEvent2 extends ApplicationEvent {

    private final String address;
    private final String content;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     * @param address
     * @param content
     */
    public BlockedListEvent2(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}
