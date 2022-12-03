package com.facebook.Facebook.controller.web;

import com.facebook.Facebook.model.Post;
import com.facebook.Facebook.service.ICommentService;
import com.facebook.Facebook.service.IPostService;
import com.facebook.Facebook.serviceimpl.CommentService;
import com.facebook.Facebook.serviceimpl.PostService;
import com.facebook.Facebook.utils.FormUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = {"/post", "/delete", "/update", "/getPost"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
public class PostController extends HttpServlet {

    private final IPostService postService;
    private final ICommentService commentService;

    public PostController() {
        commentService = new CommentService();
        postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/delete")) {
            String postId = req.getParameter("id");
            commentService.delete(Integer.valueOf(postId));
            postService.delete(Integer.valueOf(postId));
            RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
            rd.forward(req, resp);
        } else if (path.equals("/getPost")) {
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            String postId = req.getParameter("id");
            Post post = postService.findOneById(Integer.valueOf(postId));
            mapper.writeValue(resp.getOutputStream(), post);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if (action != null && action.equals("/post")) {
            Post post = FormUtil.toModel(Post.class, req);
            post.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            int result = postService.save(post);
            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/homepage");
            }
        } else if (action != null && action.equals("/update")) {
            String postId = req.getParameter("id");
            Post oldPost = postService.findOneById(Integer.valueOf(postId));
            Post updateInfo = FormUtil.toModel(Post.class, req);
            oldPost.setModifiedDate(new Timestamp(System.currentTimeMillis()));
            oldPost.setFileUrl(updateInfo.getFileUrl());
            oldPost.setContent(updateInfo.getContent());
            oldPost.setMode(updateInfo.getMode());
            postService.update(oldPost);
            resp.sendRedirect(req.getContextPath() + "/homepage");
        }
    }
}
