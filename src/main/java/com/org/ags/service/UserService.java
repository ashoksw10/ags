package com.org.ags.service;

import com.org.ags.model.User;

import java.util.List;


public interface UserService {

    User createUser(User user);

    public List<User> getUsers();
    public User getUsersById(Integer userId);
}
