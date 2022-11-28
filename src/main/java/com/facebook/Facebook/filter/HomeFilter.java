package com.facebook.Facebook.filter;

import com.facebook.Facebook.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) servletRequest).getServletPath();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(requestURI.equals("/register") || requestURI.equals("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            User user = (User) session.getAttribute("USERMODEL");
            if(user != null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                RequestDispatcher rd = servletRequest.getRequestDispatcher("/views/main/register.jsp");
                rd.include(servletRequest,servletResponse);
            }
        }
    }
}
