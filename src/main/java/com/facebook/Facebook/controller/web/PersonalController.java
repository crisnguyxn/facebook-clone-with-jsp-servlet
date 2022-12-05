package com.facebook.Facebook.controller.web;

import com.facebook.Facebook.model.Friend;
import com.facebook.Facebook.model.User;
import com.facebook.Facebook.service.IFriendService;
import com.facebook.Facebook.service.IUserService;
import com.facebook.Facebook.serviceimpl.FriendService;
import com.facebook.Facebook.serviceimpl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@WebServlet(urlPatterns = {"/profile", "/userInfo", "/updateUser"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
public class PersonalController extends HttpServlet {

    private final IUserService userService;
    private final IFriendService friendService;
    public PersonalController() {
        friendService = new FriendService();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if (action != null && action.equals("/profile")) {
            String userId = req.getParameter("id");
            User user = userService.findUserById(Integer.valueOf(userId));
            List<Friend> friendList = friendService.findAllById(Integer.valueOf(userId));
            user.setFriendList(friendList);
            User loggedUser = (User) req.getSession().getAttribute("USERMODEL");
            req.setAttribute("loggedUser",loggedUser);
            req.setAttribute("userInfo",user);
            RequestDispatcher rd = req.getRequestDispatcher("/views/main/personalpage.jsp");
            rd.forward(req,resp);
        } else if (action != null && action.equals("/userInfo")) {
            ObjectMapper mapper = new ObjectMapper();
            resp.setContentType("application/json");
            String userId = req.getParameter("id");
            User user = userService.findUserById(Integer.valueOf(userId));
            mapper.writeValue(resp.getOutputStream(), user);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        String realPath = req.getServletContext().getRealPath("/img");
        String filePath = null;
        ObjectMapper mapper = new ObjectMapper();
        if (action != null && action.equals("/updateUser")) {
            resp.setContentType("application/json");
            String userId = req.getParameter("id");
            User user = userService.findUserById(Integer.valueOf(userId));
            Collection<Part> parts = req.getParts();
            for (Part part : parts) {
                if(part.getSubmittedFileName() != null){
                    filePath = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    part.write(realPath + "/" + filePath);
                    if(part.getName().equals("coverFile")){
                        user.setCoverPhoto("img/"+filePath);
                    }else{
                        user.setAvtPhoto("img/"+filePath);
                    }
                }else{
                    if(part.getName().equals("coverFile")){
                        user.setCoverPhoto(user.getCoverPhoto());
                    }else{
                        user.setAvtPhoto(user.getAvtPhoto());
                    }
                }
            }
            userService.updateUser(user);
            mapper.writeValue(resp.getOutputStream(),user);
        }
    }
}
