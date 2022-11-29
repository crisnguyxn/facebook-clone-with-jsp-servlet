package com.facebook.Facebook.model;

public class Comment extends AbstractModel<Comment>{
    private String message;
    private int userId;
    private int postId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String content) {
        this.message = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
