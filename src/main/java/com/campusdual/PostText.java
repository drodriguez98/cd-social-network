// Package.

package com.campusdual;

// Imports.

import com.campusdual.util.Utils;

// TextPost Class (extends Post).

public class PostText extends com.campusdual.Post {

    // Attributes.

    private String content;

    // Constructor.

    public PostText(String title, String content) {

        super (title);

        this.content = content;

    }

    // Getters and Setters.

    public String getContent() {
        return this.content;
    }

    // Override to convert to string.

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("=== ");
        sb.append(this.getTitle());
        sb.append(" ===");
        sb.append("\n\t ID: " + this.getPostId());
        sb.append("\n\t Date: ").append(this.getSdf().format(this.getPostDate()));
        sb.append("\n\t Content: ").append(this.getContent());
        sb.append("\n\t Comments ("+this.getCommentList().size()+"):\n");
        sb.append(Utils.returnShowFromList(this.getCommentList(), true));

        return sb.toString();

    }

}
