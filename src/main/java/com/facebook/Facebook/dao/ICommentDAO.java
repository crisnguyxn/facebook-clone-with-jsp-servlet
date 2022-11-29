package com.facebook.Facebook.dao;

import com.facebook.Facebook.model.Comment;

public interface ICommentDAO extends GenericDAO<Comment> {
    Integer save(Comment comment);
}
