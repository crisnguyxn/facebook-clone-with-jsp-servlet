package com.facebook.Facebook.daoimpl;

import com.facebook.Facebook.dao.IFriendDAO;
import com.facebook.Facebook.mapper.FriendMapper;
import com.facebook.Facebook.model.Friend;

import java.util.List;

public class FriendDAO extends AbstractDAO<Friend> implements IFriendDAO {

    @Override
    public Integer add(Friend aFriend) {
        String sql = "INSERT INTO friend(friendid,loggedid,createddate) values (?,?,?)";
        return save(sql, aFriend.getFriendId(),aFriend.getLoggedId(),aFriend.getCreatedDate());
    }

    @Override
    public List<Friend> findAllById(Integer loggedId) {
        String sql = "SELECT * FROM friend as f INNER JOIN user as u ON f.friendid = u.id WHERE f.loggedid = ?";
        return query(sql, new FriendMapper(),loggedId);
    }
}
