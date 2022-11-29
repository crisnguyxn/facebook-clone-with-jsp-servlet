package com.facebook.Facebook.daoimpl;

import com.facebook.Facebook.dao.IPostDAO;
import com.facebook.Facebook.mapper.PostMapper;
import com.facebook.Facebook.model.Post;

import java.util.List;

public class PostDAO extends AbstractDAO<Post> implements IPostDAO {
    private static final int PUBLIC_STATUS = 1;
    @Override
    public Integer create(Post post) {
        String sql = "INSERT INTO post(content,mode, userid,createddate,fileUrl) values (?,?,?,?,?)";
        return save(sql,post.getContent(),post.getMode(),post.getUserId(),post.getCreatedDate(),post.getFileUrl());
    }

    @Override
    public List<Post> findAll() {
        String sql = "SELECT * FROM post AS p INNER JOIN user AS u ON p.userid = u.id  WHERE mode = ? ORDER BY p.createddate DESC";
        return query(sql,new PostMapper(),PUBLIC_STATUS);
    }
}
