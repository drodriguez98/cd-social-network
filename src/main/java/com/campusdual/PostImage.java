// Package.

package com.campusdual;

// Imports.

import com.campusdual.util.Utils;

// ImagePost Class (extends Post).

public class PostImage extends com.campusdual.Post {

    // Attributes.

    private String dimension;

    // Constructor.

    public PostImage(String title, String dimension) {

        super(title);

        this.dimension = dimension;

    }

    // Getters and Setters.

    public String getDimension() { return this.dimension; }

    // Override to convert to string.

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("=== " + this.getTitle());
        sb.append(" ===");
        sb.append("\n\tID: " + this.getPostId());
        sb.append("\n\tDate: "+ this.getFormatedDate());
        sb.append("\n\tDimensions: " + this.getDimension());
        sb.append("\n\tComments ("+this.getCommentList().size()+"):\n");
        sb.append(Utils.returnShowFromList(this.getCommentList(), true));

        return sb.toString();

    }

}