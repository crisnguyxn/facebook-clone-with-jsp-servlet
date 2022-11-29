package com.facebook.Facebook.serviceimpl;

import com.facebook.Facebook.dao.ICommentDAO;
import com.facebook.Facebook.daoimpl.CommentDAO;
import com.facebook.Facebook.model.Comment;
import com.facebook.Facebook.service.ICommentService;

public class CommentService implements ICommentService {

    private ICommentDAO commentDAO;
    public CommentService(){
        commentDAO = new CommentDAO();
    }
    @Override
    public Integer create(Comment comment) {
        return commentDAO.save(comment);
    }
}
