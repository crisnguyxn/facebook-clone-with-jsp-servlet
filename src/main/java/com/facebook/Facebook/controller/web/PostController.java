package com.facebook.Facebook.controller.web;

import com.facebook.Facebook.model.Post;
import com.facebook.Facebook.model.User;
import com.facebook.Facebook.service.IPostService;
import com.facebook.Facebook.serviceimpl.PostService;
import com.facebook.Facebook.utils.FormUtil;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;

@WebServlet(urlPatterns = {"/post","/getImg"})
@MultipartConfig(fileSizeThreshold=1024*1024*10,
                maxFileSize=1024*1024*50,
                maxRequestSize=1024*1024*100)
public class PostController extends HttpServlet {

    private IPostService postService;

    public PostController(){
        postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message","this is init message");
        RequestDispatcher rd = req.getRequestDispatcher("/views/main/friends.jsp");
        rd.forward(req,resp);
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
        }else if(action != null && action.equals("/getImg")){
            Part part = req.getPart("file");
            String realPath = req.getServletContext().getRealPath("/img");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            part.write(realPath+"/"+fileName);
            RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
            rd.forward(req,resp);
        }
    }
}
