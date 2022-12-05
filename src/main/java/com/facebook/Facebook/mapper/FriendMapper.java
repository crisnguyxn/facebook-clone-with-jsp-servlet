package com.facebook.Facebook.mapper;

import com.facebook.Facebook.model.Friend;
import com.facebook.Facebook.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendMapper implements IRowMapper<Friend> {

    @Override
    public Friend rowMapper(ResultSet resultSet) {
       try{
            Friend friend = new Friend();
            friend.setId(resultSet.getInt("id"));
            friend.setFriendId(resultSet.getInt("friendid"));
            friend.setLoggedId(resultSet.getInt("loggedid"));
            friend.setCreatedDate(resultSet.getTimestamp("createddate"));
            User user = new User();
            user.setId(resultSet.getInt("friendid"));
            user.setFirstName(resultSet.getString("firstname"));
            user.setSurName(resultSet.getString("surname"));
            user.setAvtPhoto(resultSet.getString("avtphoto"));
            friend.setUser(user);
            return friend;
       }catch(SQLException e){
           return null;
       }
    }
}
