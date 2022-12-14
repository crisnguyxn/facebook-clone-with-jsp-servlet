package com.facebook.Facebook.service;

import com.facebook.Facebook.model.User;

public interface IUserService {
    Integer save(User user);
    User findUserByEmail(String email);
    User findUserById(Integer userId);
    void updateUser(User updatedUser);
}
