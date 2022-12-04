package com.facebook.Facebook.daoimpl;

import com.facebook.Facebook.dao.IUserDAO;
import com.facebook.Facebook.mapper.UserMapper;
import com.facebook.Facebook.model.User;
import java.util.List;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {
    @Override
    public Integer create(User user) {
        String sql = "INSERT INTO user(firstname,surname,email,password,date, month, year, gender,createddate, createdby) values (?,?,?,?,?,?,?,?,?,?)";
        return save(sql,user.getFirstName(),user.getSurName(),user.getEmail(),user.getPassword(),user.getDate(),user.getMonth(),user.getYear(),user.getGender(),user.getCreatedDate(),user.getCreatedBy());
    }

    @Override
    public User findUserByEmail(String email) {
        String sql= "SELECT * FROM user WHERE email = ?";
        List<User> users = query(sql,new UserMapper(),email);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public User findUserById(Integer userId) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<User> users = query(sql, new UserMapper(),userId);
        return users.isEmpty()?null:users.get(0);
    }

    @Override
    public void update(User updatedUser) {
        String sql = "UPDATE user SET coverPhoto = ? , avtPhoto = ? WHERE id =?";
        update(sql, updatedUser.getCoverPhoto(),updatedUser.getAvtPhoto(),updatedUser.getId());
    }
}
