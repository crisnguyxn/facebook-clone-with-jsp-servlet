package com.facebook.Facebook.mapper;

import com.facebook.Facebook.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IRowMapper<User> {
    @Override
    public User rowMapper(ResultSet resultSet) {
        try{
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("firstname"));
            user.setSurName(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setDate(resultSet.getInt("date"));
            user.setMonth(resultSet.getInt("month"));
            user.setYear(resultSet.getInt("year"));
            user.setCreatedDate(resultSet.getTimestamp("createddate"));
            user.setCreatedBy(resultSet.getString("createdby"));
            if(resultSet.getTimestamp("modifieddate")!=null){
                user.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            }
            if(resultSet.getString("modifiedby") !=null ){
                user.setModifiedBy(resultSet.getString("modifiedby"));
            }
            return user;
        }catch(SQLException e){
            return null;
        }
    }
}
