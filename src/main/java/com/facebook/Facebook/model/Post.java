package com.facebook.Facebook.model;

import java.sql.Blob;
import java.util.List;

public class Post extends AbstractModel<Post> {
    private int userId;
    private int mode;
    private String content;
    private User user;
    private String fileUrl;
    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String filePath) {
        this.fileUrl = filePath;
    }
}
