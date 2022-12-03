package com.facebook.Facebook.daoimpl;

import com.facebook.Facebook.dao.IPostDAO;
import com.facebook.Facebook.mapper.PostMapper;
import com.facebook.Facebook.model.Post;

import java.util.List;

public class PostDAO extends AbstractDAO<Post> implements IPostDAO {
    private static final int PUBLIC_STATUS = 1;
    @Override
    public Integer create(Post post) {
        if(post.getFileUrl().equals("")){
            String sql = "INSERT INTO post(content,mode, userid,createddate) values (?,?,?,?)";
            return save(sql,post.getContent(),post.getMode(),post.getUserId(),post.getCreatedDate());
        }
        String sql = "INSERT INTO post(content,mode, userid,createddate,fileUrl) values (?,?,?,?,?)";
        return save(sql,post.getContent(),post.getMode(),post.getUserId(),post.getCreatedDate(),post.getFileUrl());
    }

    @Override
    public List<Post> findAll() {
        String sql = "SELECT * FROM post AS p INNER JOIN user AS u ON p.userid = u.id  WHERE mode = ? ORDER BY p.createddate DESC";
        return query(sql,new PostMapper(),PUBLIC_STATUS);
    }

    @Override
    public Post findOneById(Integer postId) {
        String sql = "SELECT * FROM post AS p INNER JOIN user AS u ON p.userid = u.id WHERE p.id = ?";
        List<Post> posts = query(sql, new PostMapper(),postId);
        return posts.isEmpty() ? null : posts.get(0);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM post WHERE id = ?";
        delete(sql,id);
    }

    @Override
    public void update(Post updatedPost) {
        String sql = "UPDATE post SET content = ?,mode = ?,fileUrl = ? ,createddate = ? ,modifieddate = ? WHERE id = ?";
        update(sql, updatedPost.getContent(),updatedPost.getMode(),updatedPost.getFileUrl(),updatedPost.getCreatedDate(),updatedPost.getModifiedDate(),updatedPost.getId());
    }
}
