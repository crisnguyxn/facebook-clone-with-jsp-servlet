package com.facebook.Facebook.service;

import com.facebook.Facebook.model.Friend;

import java.util.List;

public interface IFriendService{
    Integer addFriend(Friend aFriend);
    List<Friend> findAllById(Integer loggedId);
}
