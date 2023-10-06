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
    private List<Comment> commentList = new ArrayList<>();

    // Constructor.

    public Post (String title) {

        this.title = title;
        this.postDate = new Date();
        this.incrementGlobalIdPost();

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
    public List<Comment> getCommentList() {
        return this.commentList;
    }
    public SimpleDateFormat getSdf() {
        return this.sdf;
    }
    public String getFormatedDate(){
        return this.getSdf().format(this.getPostDate());
    }

    // METHODS.

    // Aumenta el ID con el que se crea un Post.

    private void incrementGlobalIdPost() {

        this.postId = Post.globalId;
        Post.globalId++;

    }

    // Añade un comentario a la lista de comentarios de un post y también a la lista del usuario que lo escribe (sin Utils).

    public void addComment (String commentText, User u){

        Comment comment = new Comment(commentText, u);

        this.getCommentList().add(comment);
        u.addComment(comment);
        comment.setPost(this);

    }

    // Añade un comentario a la lista de comentarios de un post y también a la lista de comentarios del usuario que lo escribe (con utils).

    public void addComment (User u) {

        String commentText = Utils.string("Enter a comment: ");

        Comment comment = new Comment(commentText, u);

        this.getCommentList().add(comment);
        u.addComment(comment);
        comment.setPost(this);

    }

    // Borra un comentario de la lista de comentarios de un post.

    public void deleteComment (Comment c){

        this.getCommentList().remove(c);

    }

}