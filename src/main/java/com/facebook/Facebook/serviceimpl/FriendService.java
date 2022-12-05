package com.facebook.Facebook.serviceimpl;

import com.facebook.Facebook.dao.IFriendDAO;
import com.facebook.Facebook.daoimpl.FriendDAO;
import com.facebook.Facebook.model.Friend;
import com.facebook.Facebook.service.IFriendService;

import java.util.List;

public class FriendService implements IFriendService {

    private final IFriendDAO friendDAO;
    public FriendService(){
        friendDAO = new FriendDAO();
    }

    @Override
    public Integer addFriend(Friend aFriend) {
        return friendDAO.add(aFriend);
    }

    @Override
    public List<Friend> findAllById(Integer loggedId) {
        return friendDAO.findAllById(loggedId);
    }
}
