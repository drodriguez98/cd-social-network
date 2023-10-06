package com.campusdual.socialnetwork;

import com.campusdual.Comment;
import com.campusdual.Post;
import com.campusdual.PostText;
import com.campusdual.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    /*

    private int globalId;

    // Comprueba que se incrementa el id global de los objetos Post y se añade como atributo al nuevo objeto.

    @Test
    @DisplayName("POST - TEST - INCREMENT GLOBAL ID POST")
    void incrementGlobalIdPostTest() {

        int lastId = Post.getGlobalId();

        Post p1 = new PostText("Post txt de prueba", "Libros que quiero leer");

        assertEquals(lastId + 1, p1.getPostId());

    }

     */

    // Comprueba que un post puede añadir un comentario a su lista de comentarios.

    @Test
    @DisplayName("POST - TEST - ADD COMENT")
    void addCommentTest() {

        Post p1 = new PostText("Post txt de prueba", "Libros que quiero leer");
        User u1 = new User("Diego");

        int sizePostCommentList = p1.getCommentList().size();

        p1.addComment("Me he leido algunos y son maravillosos", u1);
        assertEquals(sizePostCommentList + 1, p1.getCommentList().size());

    }

    // Comprueba que un post puede eliminar un comentario de su lista de comentarios.

    @Test
    @DisplayName("POST - TEST - DELETE COMMENT")
    void deleteCommentTest() {

        Post p1 = new PostText("Post txt de prueba", "Libros que quiero leer");
        User u1 = new User("Diego");
        Comment c1 = new Comment("No paras eh primaso!!", u1);

        p1.getCommentList().add(c1);
        assertTrue(p1.getCommentList().contains(c1));

        int sizeCommentList = p1.getCommentList().size();

        p1.deleteComment(c1);
        assertEquals(sizeCommentList -1, p1.getCommentList().size());
        assertFalse(p1.getCommentList().contains(c1));

    }

}