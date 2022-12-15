package com.facebook.Facebook.dao;

import com.facebook.Facebook.model.Post;

import java.util.List;


public interface IPostDAO extends GenericDAO<Post> {
    Integer create(Post post);
    List<Post> findAll();
    Post findOneById(Integer postId);
    void delete(Integer id);
    void update(Post updatedPost);
    List<Post> findAllByUserId(Integer userId);
}
