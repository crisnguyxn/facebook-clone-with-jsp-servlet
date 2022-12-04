package com.facebook.Facebook.mapper;

import com.facebook.Facebook.model.Post;
import com.facebook.Facebook.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements IRowMapper<Post> {

    @Override
    public Post rowMapper(ResultSet resultSet) {
        try{
            Post post = new Post();
            post.setId(resultSet.getInt("id"));
            post.setContent(resultSet.getString("content"));
            post.setMode(resultSet.getInt("mode"));
            post.setCreatedDate(resultSet.getTimestamp("createddate"));
            if(resultSet.getString("fileUrl") != null){
                post.setFileUrl(resultSet.getString("fileUrl"));
            }
            if(resultSet.getString("modifieddate") != null){
                post.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            }
            User user = new User();
            user.setId(resultSet.getInt("userid"));
            user.setFirstName(resultSet.getString("firstname"));
            user.setSurName(resultSet.getString("surname"));
            user.setCoverPhoto(resultSet.getString("coverphoto"));
            user.setAvtPhoto(resultSet.getString("avtphoto"));
            post.setUser(user);
            return post;
        }catch(SQLException e){
            return null;
        }
    }
}
