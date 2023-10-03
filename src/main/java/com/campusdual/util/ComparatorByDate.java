package com.campusdual.util;

import com.campusdual.Post;

import java.util.Comparator;
import java.util.Date;

public class ComparatorByDate implements Comparator<Post> {

    @Override
    public int compare(Post o1, Post o2) {

        Date ps1 = o1.getPostDate();
        Date ps2 = o2.getPostDate();

        if (ps1.equals(ps2)) {

            return 0;

        } else if (ps1.before(ps2)) {

            return -1;

        }else{

            return 1;

        }

    }

}