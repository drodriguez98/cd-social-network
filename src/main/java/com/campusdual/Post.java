// Package.

package com.campusdual;

// Imports.

import com.campusdual.util.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Post Class.

public class Post {

    // Attributes.

    private static int globalId = 1;
    private int postId;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private Date postDate;
    private String title;
    private List<com.campusdual.Comment> commentList = new ArrayList<>();

    // Constructor.

    public Post (String title) {

        this.title = title;
        this.postDate = new Date();
        this.createPost();

    }

    // Getters and Setters.

    public int getPostId() {
        return this.postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public static int getGlobalId() {
        return Post.globalId;
    }
    public Date getPostDate() {
        return this.postDate;
    }
    public String getTitle() {
        return this.title;
    }
    public List<com.campusdual.Comment> getCommentList() {
        return this.commentList;
    }
    public SimpleDateFormat getSdf() {
        return this.sdf;
    }
    public String getFormatedDate(){
        return this.getSdf().format(this.getPostDate());
    }

    // Methods.

    private void createPost() {

        this.postId = Post.globalId;
        Post.globalId++;

    }

    public void addComment(User user) {

        String commentText = Utils.string("Enter a comment: ");

        com.campusdual.Comment comment = new com.campusdual.Comment(commentText, user);

        this.getCommentList().add(comment);
        user.addComment(comment);
        comment.setPost(this);

    }

    public  void addComment(String commentText, User user){

        com.campusdual.Comment comment = new com.campusdual.Comment(commentText, user);

        this.getCommentList().add(comment);
        user.addComment(comment);
        comment.setPost(this);

    }

}
