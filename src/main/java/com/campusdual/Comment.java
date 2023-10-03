// Package.

package com.campusdual;

// Imports.

import java.text.SimpleDateFormat;
import java.util.Date;

// Comment Class.

public class Comment {

    // Attributes.

    private String content;
    private Date commentDate;
    private User user;
    private Post post;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    // Constructor.

    public Comment (String content, User user) {

        this.content = content;
        this.commentDate = new Date();
        this.user = user;

    }

    // Getters and Setters.

    public Post getPost() {
        return this.post;
    }
    public String getContent() {
        return this.content;
    }
    public Date getCommentDate() {
        return this.commentDate;
    }
    public String getCommentDateFormated() {
        return this.getSdf().format(this.getCommentDate());
    }
    public User getUser() {
        return this.user;
    }
    public SimpleDateFormat getSdf() {
        return this.sdf;
    }
    public void setPost(Post post) { this.post = post; }

    // Override to convert to string.

    @Override
    public String toString() {

        return this.getUser()+" commented: "+ this.getContent() + " ("+this.getCommentDateFormated()+")";

    }

}