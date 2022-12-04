package com.facebook.Facebook.serviceimpl;

import com.facebook.Facebook.dao.IUserDAO;
import com.facebook.Facebook.daoimpl.UserDAO;
import com.facebook.Facebook.model.User;
import com.facebook.Facebook.service.IUserService;

public class UserService implements IUserService {
    private final IUserDAO userDAO;
    public UserService(){
        userDAO = new UserDAO();
    }
    @Override
    public Integer save(User user) {
        return userDAO.create(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Override
    public User findUserById(Integer userId) {
        return userDAO.findUserById(userId);
    }

    @Override
    public void updateUser(User updatedUser) {
        userDAO.update(updatedUser);
    }
}
