package com.facebook.Facebook.serviceimpl;

import com.facebook.Facebook.dao.IPostDAO;
import com.facebook.Facebook.daoimpl.PostDAO;
import com.facebook.Facebook.model.Post;
import com.facebook.Facebook.service.IPostService;
import java.util.List;

public class PostService implements IPostService {

    private final IPostDAO postDAO;
    public PostService(){
        postDAO = new PostDAO();
    }

    @Override
    public Integer save(Post post) {
        return postDAO.create(post);
    }

    @Override
    public List<Post> findAll() {
        return postDAO.findAll();
    }

    @Override
    public Post findOneById(Integer postId) {
        return postDAO.findOneById(postId);
    }

    @Override
    public void delete(Integer id) {
        postDAO.delete(id);
    }

    @Override
    public void update(Post updatedPost) {
        postDAO.update(updatedPost);
    }

    @Override
    public List<Post> findByUserId(Integer userId) {
        return postDAO.findAllByUserId(userId);
    }
}
