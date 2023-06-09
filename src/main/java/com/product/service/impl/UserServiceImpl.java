package com.product.service.impl;

import com.product.model.User;
import com.product.repo.UserRepo;
import com.product.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;

    }

    @Override
    public User getUser(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Optional<User> getUserByUsername(String name) {
        return userRepo.findByUsername(name);
    }
}
