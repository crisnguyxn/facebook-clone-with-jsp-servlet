package com.facebook.Facebook.controller.web;

import com.facebook.Facebook.model.Comment;
import com.facebook.Facebook.service.ICommentService;
import com.facebook.Facebook.serviceimpl.CommentService;
import com.facebook.Facebook.utils.FormUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = {"/postCmt"})
public class CommentController extends HttpServlet {

    private ICommentService commentService;
    public CommentController(){
        commentService = new CommentService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Comment comment = FormUtil.toModel(Comment.class,req);
        comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        int result = commentService.create(comment);
        if(result > 0 ){
            resp.sendRedirect(req.getServletPath()+"/homepage");
        }
    }
}
