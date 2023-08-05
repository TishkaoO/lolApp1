package com.example.lolapp.listeners;

import com.example.lolapp.entity.User;
import com.example.lolapp.service.mail.MessageSender;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventRegisteredListener {
    private final MessageSender messageSender;

    public UserEventRegisteredListener(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @EventListener
    public void handleUserRegisteredEvent(final UserRegisteredEvent event) {
        User user = event.getUser();
        String login = user.getLogin();
        messageSender.sendMessage(login);
    }
}
