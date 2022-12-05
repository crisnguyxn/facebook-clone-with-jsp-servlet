package com.facebook.Facebook.dao;

import com.facebook.Facebook.model.Friend;

import java.util.List;

public interface IFriendDAO extends GenericDAO<Friend> {
    Integer add(Friend aFriend);
    List<Friend> findAllById(Integer loggedId);
}
