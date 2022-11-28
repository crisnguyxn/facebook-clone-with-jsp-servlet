package com.facebook.Facebook.dao;

import com.facebook.Facebook.model.User;

public interface IUserDAO extends GenericDAO<User> {
    Integer create(User user);
    User findUserByEmail(String email);
}
