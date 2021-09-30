package com.ofben.autordemo.spring.ioc.application.two;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * {@link ApplicationEventPublisherAware}
 *
 * @date 2021-09-30
 * @since 1.0.0
 */
public class EmailService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void sendEmail(String address, String content) {
        publisher.publishEvent(new BlockedListEvent(this, address, content));
    }
}
