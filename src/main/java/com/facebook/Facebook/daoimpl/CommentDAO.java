package com.facebook.Facebook.daoimpl;

import com.facebook.Facebook.dao.ICommentDAO;
import com.facebook.Facebook.mapper.CommentMapper;
import com.facebook.Facebook.model.Comment;

import java.util.List;

public class CommentDAO extends AbstractDAO<Comment> implements ICommentDAO {

    @Override
    public Integer save(Comment comment) {
        String sql = "INSERT INTO comment (message,userid,postid,createddate) values(?,?,?,?)";
        return save(sql,comment.getMessage(),comment.getUserId(),comment.getPostId(),comment.getCreatedDate());
    }

    @Override
    public List<Comment> findAll(Integer postId) {
        String sql = "SELECT * FROM comment as c INNER JOIN user as u ON c.userid = u.id WHERE c.postid = ? ORDER BY c.createddate DESC";
        return query(sql,new CommentMapper(),postId);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM comment WHERE postid = ?";
        delete(sql,id);
    }

}
