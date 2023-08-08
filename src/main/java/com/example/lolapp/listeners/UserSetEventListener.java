package com.example.lolapp.listeners;

import com.example.lolapp.entity.User;
import com.example.lolapp.service.UserService;
import com.example.lolapp.service.mail.MessageSender;
import com.example.lolapp.store.UserRepo;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserSetEventListener {
    private final UserRepo userRepo;

    public UserSetEventListener(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @EventListener
    public void handleUserRegisteredEvent(final UserRegisteredEvent event) {
        User user = event.getUser();
        user.setLogin("newLogin");
        userRepo.save(user);
    }
}
