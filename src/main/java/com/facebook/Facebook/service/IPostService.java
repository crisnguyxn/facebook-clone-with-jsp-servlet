package com.facebook.Facebook.service;

import com.facebook.Facebook.model.Post;

import java.util.List;

public interface IPostService {
    Integer save(Post post);
    List<Post> findAll();
    Post findOneById(Integer postId);
    void delete(Integer id);
    void update(Post updatedPost);
    List<Post> findByUserId(Integer userId);
}
