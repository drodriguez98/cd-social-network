package com.campusdual.socialnetwork;

import com.campusdual.Comment;
import com.campusdual.Post;
import com.campusdual.PostText;
import com.campusdual.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    // Comprueba que cuando un usuario comienza a seguir a otro, éste se añade a su lista de amigos.

    @Test
    @DisplayName("USER - TEST - ADD FRIEND")
    void addFriendTest() {

        User u1 = new User("Diego");
        User u2 = new User("Damián");

        int sizeFriendList = u1.getFriendList().size();
        u1.addFriend(u2);
        assertTrue(u1.getFriendList().contains(u2));
        assertEquals(sizeFriendList +1, u1.getFriendList().size());

    }

    // Comprueba que cuando un usuario crea un post, éste se añade a su lista de posts.

    @Test
    @DisplayName("USER - TEST - ADD POST")
    public void addPostTest() {

        User u1 = new User ("Diego");
        Post p1 = new PostText("Post txt de prueba", "Libros que quiero leer");

        int sizePostList = u1.getPostList().size();
        u1.addPost(p1);
        assertEquals(sizePostList +1, u1.getPostList().size());
        assertTrue(u1.getPostList().contains(p1));

    }

    // Comprueba que cuando un usuario comenta en un post, éste se añade a su lista de comentarios.

    @Test
    @DisplayName("USER - TEST - ADD COMMENT")
    public void addCommentTest() {

        User u1 = new User ("Diego");
        Comment c1 = new Comment("No paras eh primaso!!", u1);

        int sizeCommentList = u1.getCommentList().size();

        u1.addComment(c1);
        assertEquals(sizeCommentList +1, u1.getCommentList().size());
        assertTrue(u1.getCommentList().contains(c1));

    }

    // Comprueba que cuando un usuario deja de seguir a otro, éste desaparece de su lista de amigos.

    @Test
    @DisplayName("USER - TEST - DELETE FRIEND")
    void deleteFriendTest() {

        User u1 = new User("Diego");
        User u2 = new User("Damián");

        u1.getFriendList().add(u2);
        assertTrue(u1.getFriendList().contains(u2));

        int sizeFriendList = u1.getFriendList().size();
        u1.deleteFriend(u2);
        assertFalse(u1.getFriendList().contains(u2));
        assertEquals(sizeFriendList -1, u1.getFriendList().size());

    }

    // Comprueba que cuando un usuario borra un post, éste desaparece a su lista de posts.

    @Test
    @DisplayName("USER - TEST - DELETE POST")
    public void deletePostTest() {

        User u1 = new User ("Diego");
        Post p1 = new PostText("Post txt de prueba", "Libros que quiero leer");

        u1.getPostList().add(p1);
        assertTrue(u1.getPostList().contains(p1));

        int sizePostList = u1.getPostList().size();
        u1.deletePost(p1);
        assertFalse(u1.getFriendList().contains(p1));
        assertEquals(sizePostList -1, u1.getPostList().size());

    }

    // Comprueba que cuando un usuario borra un comentario suyo en un post, éste desaparece de su lista de comentarios.

    @Test
    @DisplayName("USER - TEST - DELETE COMMENT")
    public void deleteCommentTest() {

        User u1 = new User ("Diego");
        Comment c1 = new Comment("No paras eh primaso!!", u1);

        u1.getCommentList().add(c1);
        assertTrue(u1.getCommentList().contains(c1));

        int sizeCommentList = u1.getCommentList().size();

        u1.deleteComment(c1);
        assertEquals(sizeCommentList -1, u1.getCommentList().size());
        assertFalse(u1.getCommentList().contains(c1));

    }

    /*

    @Test
    @DisplayName("USER - TEST - DELETE COMMENT")
    public void friendsSuggestion() { }

    */

}