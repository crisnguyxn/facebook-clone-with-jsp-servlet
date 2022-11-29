package com.facebook.Facebook.daoimpl;

import com.facebook.Facebook.dao.ICommentDAO;
import com.facebook.Facebook.model.Comment;

public class CommentDAO extends AbstractDAO<Comment> implements ICommentDAO {

    @Override
    public Integer save(Comment comment) {
        String sql = "INSERT INTO comment (content,userid,postid,createddate) values(?,?,?,?)";
        return save(sql,comment.getContent(),comment.getUserId(),comment.getPostId(),comment.getCreatedDate());
    }
}
