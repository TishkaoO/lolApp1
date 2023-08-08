package com.example.lolapp.service;

import com.example.lolapp.entity.User;
import com.example.lolapp.store.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo repo;
    private final UserPublisherService userPublisherService;

    public UserService(UserRepo repo, UserPublisherService userPublisherService) {
        this.repo = repo;
        this.userPublisherService = userPublisherService;
    }

    public User createUser(User user) {
        //valid
        User reg = repo.save(user);
        userPublisherService.publishUserRegisteredEvent(reg);
        return reg;
    }
}
