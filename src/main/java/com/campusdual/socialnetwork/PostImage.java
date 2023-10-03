package com.campusdual.socialnetwork;

import java.time.LocalDateTime;

public class PostImage extends Post {

    private String size;

    public PostImage(int id, User user, String title, LocalDateTime date, String size) {

        super(id, user, title, date);
        this.size = size;

    }

}