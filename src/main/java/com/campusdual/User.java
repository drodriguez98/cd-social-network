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
    private List <com.campusdual.Post> postList = new LinkedList<>();
    private List <com.campusdual.Comment> commentList = new ArrayList<>();

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
    public List <com.campusdual.Post> getPostList() {
        return this.postList;
    }
    public List <com.campusdual.Comment> getCommentList() { return this.commentList; }

    // Methods.

    public void addPost (com.campusdual.Post p) { ((LinkedList) this.getPostList()).addFirst(p); }
    public void addFriend (User u){
        this.getFriendList().add(u);
    }
    public void addComment (com.campusdual.Comment comment) {
        this.getCommentList().add(comment);
    }

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