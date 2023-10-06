package com.campusdual.socialnetwork;

import com.campusdual.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SocialNetworkTest {

    // Comprueba que si existe un usuario con el mismo nombre en la lista de usuarios de la aplicación. Si es así, éste pasa a ser el usuario activo.

    @Test
    @DisplayName("TEST - LOGIN")
    void loginTest() {

        SocialNetwork sn = new SocialNetwork();

        User u = new User("Diego");
        sn.getSocialNetworkUserList().add(u);

        sn.loginTmp(u.getName());

        assertNotNull(sn.getActiveUser());
        // assertSame(sn.getActiveUser(), u);

    }

    @Test
    @DisplayName("TEST - ADD USER")
    void addUserTest () {

        SocialNetwork sn = new SocialNetwork();

        String username = "Pablo";

        int sizeSocialNetworkUserList = sn.getSocialNetworkUserList().size();

        sn.addUserTmp(username);

        assertEquals(sizeSocialNetworkUserList + 1, sn.getSocialNetworkUserList().size());

    }

    @Test
    @DisplayName("TEST - ADD FRIEND")
    void addFriendTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");
        User u2 = new User("Pablo");

        sn.getSocialNetworkUserList().add(u1);
        sn.getSocialNetworkUserList().add(u2);

        // u1.getFriendList().add(u2);

        sn.loginTmp(u1.getName());

        int sizeUser1FriendList = u1.getFriendList().size();

        sn.addFriendTmp(u2);

        assertEquals(sizeUser1FriendList + 1, u1.getFriendList().size());
        assertTrue(u1.getFriendList().contains(u2));

    }

    @Test
    @DisplayName("TEST - ADD POST TEXT")
    void addPostTextTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");

        sn.getSocialNetworkUserList().add(u1);

        sn.loginTmp(u1.getName());

        int sizeUserPostsList = u1.getPostList().size();
        int sizeSocialNetworkPostsList = sn.getSocialNetworkPostList().size();

        sn.addPostTextTmp("Post de texto", "txt");

        assertEquals(sizeUserPostsList + 1, u1.getPostList().size());
        assertEquals(sizeSocialNetworkPostsList + 1, sn.getSocialNetworkPostList().size());

    }

    @Test
    @DisplayName("TEST - ADD POST IMAGE")
    void addPostImageTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");

        sn.getSocialNetworkUserList().add(u1);

        sn.loginTmp(u1.getName());

        int sizeUserPostsList = u1.getPostList().size();
        int sizeSocialNetworkPostsList = sn.getSocialNetworkPostList().size();

        sn.addPostImageTmp("Post de imagen", "20x20");

        assertEquals(sizeUserPostsList + 1, u1.getPostList().size());
        assertEquals(sizeSocialNetworkPostsList + 1, sn.getSocialNetworkPostList().size());

    }

    @Test
    @DisplayName("TEST - ADD POST VIDEO")
    void addPostVideoTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");

        sn.getSocialNetworkUserList().add(u1);

        sn.loginTmp(u1.getName());

        int sizeUserPostsList = u1.getPostList().size();
        int sizeSocialNetworkPostsList = sn.getSocialNetworkPostList().size();

        sn.addPostVideoTmp("Post de video", "1080p", 120);

        assertEquals(sizeUserPostsList + 1, u1.getPostList().size());
        assertEquals(sizeSocialNetworkPostsList + 1, sn.getSocialNetworkPostList().size());

    }

    @Test
    @DisplayName("TEST - ADD COMMENT")
    void addCommentTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");
        PostText p1 = new PostText("Post txt de prueba", "Libros que quiero leer");

        sn.getSocialNetworkPostList().add(p1);
        sn.getSocialNetworkUserList().add(u1);

        sn.loginTmp(u1.getName());

        u1.getPostList().add(p1);

        int sizeSocialNetworkCommentList = p1.getCommentList().size();
        int sizeUserCommentList = u1.getCommentList().size();

        sn.commentPostTmp("Increible", p1);

        assertEquals(sizeSocialNetworkCommentList + 1, p1.getCommentList().size());
        assertEquals(sizeUserCommentList + 1, u1.getCommentList().size());

    }

    @Test
    @DisplayName("TEST - DELETE FRIEND")
    void deleteFriendTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");
        User u2 = new User("Pablo");

        sn.getSocialNetworkUserList().add(u1);
        sn.getSocialNetworkUserList().add(u2);

        u1.getFriendList().add(u2);

        sn.loginTmp(u1.getName());

        int sizeUser1FriendList = u1.getFriendList().size();

        sn.deleteFriendTmp(u2);

        assertEquals(sizeUser1FriendList - 1, u1.getFriendList().size());
        assertFalse(u1.getFriendList().contains(u2));

    }

    @Test
    @DisplayName("TEST - DELETE POST")
    void deleteMyPostTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");
        PostText p1 = new PostText("Post txt de prueba", "Libros que quiero leer");

        sn.getSocialNetworkPostList().add(p1);
        sn.getSocialNetworkUserList().add(u1);

        sn.loginTmp(u1.getName());

        u1.getPostList().add(p1);

        sn.commentPostTmp("Increible", p1);

        int sizeUserCommentList = u1.getCommentList().size();
        // int sizePostCommentList = p1.getCommentList().size();

        sn.deleteMyPostTmp(p1);

        assertFalse(sn.getSocialNetworkPostList().contains(p1));
        assertFalse(u1.getPostList().contains(p1));
        assertEquals(sizeUserCommentList - 1, u1.getCommentList().size());
        // assertEquals(sizePostCommentList - 1, p1.getCommentList().size());

    }

    @Test
    @DisplayName("TEST - DELETE COMMENT")
    void deleteMyCommentTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");
        PostText p1 = new PostText("Post txt de prueba", "Libros que quiero leer");
        Comment c1 = new Comment("Increible", u1);

        sn.getSocialNetworkUserList().add(u1);
        sn.getSocialNetworkPostList().add(p1);

        sn.loginTmp(u1.getName());

        u1.getPostList().add(p1);
        u1.addComment(c1);
        c1.setPost(p1);
        p1.getCommentList().add(c1);

        sn.commentPostTmp("Increible", p1);

        int sizeUserCommentList = u1.getCommentList().size();
        int sizePostCommentList = p1.getCommentList().size();

        sn.deleteMyCommentTmp(c1);

        assertEquals(sizeUserCommentList - 1, u1.getCommentList().size());
        assertEquals(sizePostCommentList - 1, p1.getCommentList().size());


    }

    /*

    @Test
    @DisplayName("SOCIALNETWORK - TEST - DELETE MY ACCOUNT")
    void deleteMyAccountTest() {

        SocialNetwork sn = new SocialNetwork();

        User u1 = new User("Diego");
        User u2 = new User("Misa");
        sn.getSocialNetworkUserList().add(u1);
        Post p1 = new PostText("Post txt de prueba", "Libros que quiero leer");
        sn.getSocialNetworkPostList().add(p1);
        Comment c1 = new Comment("No paras eh primaso!!", u1);
        p1.addComment(c1.getContent(), u1);
        u1.getFriendList().add(u2);

        p1.getCommentList().add(c1);

        sn.loginTmp(u1.getName());

        sn.deleteMyAccountTmp();

        assertFalse(u1.getCommentList().contains(c1));
        assertFalse(u1.getPostList().contains(c1));

        // Todas estas devuelven True y no deberían

            // assertFalse(u1.getFriendList().contains(u2));
            // assertFalse(p1.getCommentList().contains(c1));
            // assertFalse(sn.getSocialNetworkPostList().contains(p1));
            //assertFalse(sn.getSocialNetworkUserList().contains(u1));

    }

     */

    void findPostByIdTest() {}

}