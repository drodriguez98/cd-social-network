// Package.

package com.campusdual;

// Imports.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// User Class.

public class User {

    // Attributes.

    private String name;
    private List <User> friendList= new ArrayList<>();
    private List <Post> postList = new LinkedList<>();
    private List <Comment> commentList = new ArrayList<>();

    // Constructor.

    public User (String name) {

        this.name = name;

    }

    // Getters and Setters.

    public String getName() {
        return this.name;
    }
    public List <User> getFriendList() {
        return this.friendList;
    }
    public List <Post> getPostList() {
        return this.postList;
    }
    public List <Comment> getCommentList() { return this.commentList; }

    // METHODS.

    // Añade un usuario a la lista de amigos de un usuario.

    public void addFriend (User u) {

        this.getFriendList().add(u);

    }

    // Añade un post a la lista de posts de un usuario.

    public void addPost (Post p) {

        ((LinkedList) this.getPostList()).addFirst(p);

    }

    // Añade un comentario a la lista de comentarios de un usuario.

    public void addComment (Comment c) {

        this.getCommentList().add(c);

    }

    // Borra un usuario de la lista de posts de un usuario.

    public void deleteFriend (User u) {

        this.getFriendList().remove(u);

    }

    // Borra un post de la lista de posts de un usuario.

    public void deletePost (Post p) {

        this.getPostList().remove(p);

    }

    // Borra un comentario de la lista de comentarios de un usuario.

    public void deleteComment (Comment c) {

        this.getCommentList().remove(c);

    }

    // Muestra sugerencias de usuarios a seguir.

    public List <User> friendsSuggestion() {

        List <User> suggestions = new ArrayList<>();

        for (User userFollowed : this.getFriendList()) {

            for (User userFriendFollowed : userFollowed.getFriendList()) {

                if (!this.getFriendList().contains(userFriendFollowed) && !userFriendFollowed.equals(this) && !suggestions.contains(userFriendFollowed)) {

                    suggestions.add(userFriendFollowed);

                }

            }

        }

        return suggestions;

    }

    // Override to convert to string.

    @Override
    public String toString() { return this.getName(); }

}