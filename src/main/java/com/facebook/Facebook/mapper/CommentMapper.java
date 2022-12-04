package com.facebook.Facebook.mapper;

import com.facebook.Facebook.model.Comment;
import com.facebook.Facebook.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements  IRowMapper<Comment> {
    @Override
    public Comment rowMapper(ResultSet resultSet) {
       try{
           Comment comment = new Comment();
           comment.setMessage(resultSet.getString("message"));
           comment.setUserId(resultSet.getInt("userid"));
           comment.setPostId(resultSet.getInt("postid"));
           comment.setCreatedDate(resultSet.getTimestamp("createddate"));
           User user = new User();
           user.setId(resultSet.getInt("userid"));
           user.setFirstName(resultSet.getString("firstname"));
           user.setSurName(resultSet.getString("surname"));
           user.setCoverPhoto(resultSet.getString("coverphoto"));
           user.setAvtPhoto(resultSet.getString("avtphoto"));
           comment.setUser(user);
            return comment;

       }catch(SQLException e){
           return null;
       }
    }
}
