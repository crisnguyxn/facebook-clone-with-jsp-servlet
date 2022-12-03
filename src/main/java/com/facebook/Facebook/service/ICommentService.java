package com.facebook.Facebook.service;

import com.facebook.Facebook.model.Comment;

import java.util.List;

public interface ICommentService {
    Integer create(Comment comment);
    List<Comment> findAll(Integer postId);
    void delete(Integer id);
}
