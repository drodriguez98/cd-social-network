// Package.

package com.campusdual;

// Imports.

import com.campusdual.util.Utils;

// VideoPost Class (extends Post)

public class PostVideo extends com.campusdual.Post {

    // Attributes.

    private String quality;
    private int duration;

    // Constructor.

    public PostVideo(String title, String quality, int duration) {

        super(title);

        this.quality = quality;
        this.duration = duration;

    }

    // Getters and Setters.

    public String getQuality() {
        return this.quality;
    }
    public int getDuration() {
        return this.duration;
    }

    // Override to convert to string.

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("=== " + this.getTitle());
        sb.append(" ===");
        sb.append("\n\tID: " + this.getPostId());
        sb.append("\n\tDate: "+ this.getSdf().format(this.getPostDate()));
        sb.append("\n\tQuality → "+ this.getQuality());
        sb.append("\n\tDuration → "+ this.getDuration());
        sb.append("\n\tComments ("+this.getCommentList().size()+"):");
        sb.append(Utils.returnShowFromList(this.getCommentList(), true));

        return sb.toString();

    }

}