package com.campusdual.socialnetwork;

import java.time.LocalDateTime;

public class PostText extends Post {

    private String content;

    public PostText (int id, User user, String title, LocalDateTime date, String content) {

        super (id, user, title, date);
        this.content = content;

    }

}