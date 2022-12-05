package com.facebook.Facebook.controller.web;

import com.facebook.Facebook.model.Friend;
import com.facebook.Facebook.service.IFriendService;
import com.facebook.Facebook.serviceimpl.FriendService;
import com.facebook.Facebook.utils.FormUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = {"/addfriend","/getfriends"})
public class FriendController extends HttpServlet {

    private final IFriendService friendService;
    public FriendController(){
        friendService = new FriendService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Friend aFriend = FormUtil.toModel(Friend.class,req);
        aFriend.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        int result = friendService.addFriend(aFriend);
        if(result > 0){
            mapper.writeValue(resp.getOutputStream(),aFriend);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        String loggedId = req.getParameter("id");
        List<Friend> friendList = friendService.findAllById(Integer.parseInt(loggedId));
        mapper.writeValue(resp.getOutputStream(),friendList);
    }
}
