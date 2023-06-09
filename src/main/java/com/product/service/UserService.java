package com.product.service;

import com.product.model.User;

import java.util.Optional;

public interface UserService {
    User getUser(int id);
    Optional<User> getUserByUsername(String name);
}
