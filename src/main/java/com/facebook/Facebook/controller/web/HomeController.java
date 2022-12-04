package com.facebook.Facebook.controller.web;

import com.facebook.Facebook.model.Post;
import com.facebook.Facebook.model.User;
import com.facebook.Facebook.service.ICommentService;
import com.facebook.Facebook.service.IPostService;
import com.facebook.Facebook.service.IUserService;
import com.facebook.Facebook.serviceimpl.CommentService;
import com.facebook.Facebook.serviceimpl.PostService;
import com.facebook.Facebook.serviceimpl.UserService;
import com.facebook.Facebook.utils.FormUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = {"/login", "/homepage", "/register"})
public class HomeController extends HttpServlet {
    private final IUserService userService;
    private final IPostService postService;
    private final ICommentService commentService;

    public HomeController() {
        userService = new UserService();
        postService = new PostService();
        commentService = new CommentService();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request = req.getServletPath();
        if (request.equals("/register")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/main/register.jsp");
            rd.forward(req, resp);
        } else if (request.equals("/login")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/main/login.jsp");
            rd.forward(req, resp);
        } else {
            User user = (User) req.getSession().getAttribute("USERMODEL");
            User userInfo = userService.findUserById(user.getId());
            req.setAttribute("userInfo", userInfo);
            List<Post> posts = postService.findAll();
            if (posts.size() == 0) {
                RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
                rd.forward(req, resp);
            } else {
                for (Post post : posts) {
                    post.setCommentList(commentService.findAll(post.getId()));
                };
                req.setAttribute("models",posts);
                RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
                rd.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if (action != null && action.equals("/register")) {
            User user = FormUtil.toModel(User.class, req);
            if (userService.findUserByEmail(user.getEmail()) == null) {
                user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
                user.setCreatedBy("");
                int result = userService.save(user);
                if (result > 0) {
                    resp.sendRedirect(req.getContextPath() + "/login");
                }
            } else {
                req.setAttribute("error", "Email is already taken!");
                RequestDispatcher rd = req.getRequestDispatcher("/views/main/register.jsp");
                rd.forward(req, resp);
            }
        } else if (action != null && action.equals("/login")) {
            User user = FormUtil.toModel(User.class, req);
            User userLogged = userService.findUserByEmail(user.getEmail());
            if (userLogged == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            } else {
                if (user.getPassword().equals(userLogged.getPassword())) {
                    req.getSession().setAttribute("USERMODEL", userLogged);
                    resp.sendRedirect(req.getContextPath() + "/homepage");
                } else {
                    req.setAttribute("error", "Invalid credentials!");
                    resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    RequestDispatcher rd = req.getRequestDispatcher("/views/main/login.jsp");
                    rd.forward(req, resp);
                }
            }
        }
    }
}
