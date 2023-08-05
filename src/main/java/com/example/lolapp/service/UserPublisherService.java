package com.example.lolapp.service;

import com.example.lolapp.entity.User;
import com.example.lolapp.listeners.UserRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserPublisherService {
    private final ApplicationEventPublisher eventPublisher;

    public UserPublisherService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishUserRegisteredEvent(final User reg) {
        eventPublisher.publishEvent(new UserRegisteredEvent(this, reg));
    }
}
