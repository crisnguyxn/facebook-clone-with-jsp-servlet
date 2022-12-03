package com.facebook.Facebook.dao;

import com.facebook.Facebook.model.Comment;

import java.util.List;

public interface ICommentDAO extends GenericDAO<Comment> {
    Integer save(Comment comment);
    List<Comment> findAll(Integer postId);
    void delete(Integer id);
}
