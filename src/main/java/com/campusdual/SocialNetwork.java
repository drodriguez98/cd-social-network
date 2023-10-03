// Package.

package com.campusdual;

// Imports.

import com.campusdual.util.ComparatorByDate;
import com.campusdual.util.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// SocialNet Class.

public class SocialNetwork {

	// Attributes.

	private List<User> socialNetworkUserList = new ArrayList<>();
	private List<Post> socialNetworkPostList = new ArrayList<>();
	private User activeUser;

	// Getters and Setters.

	public List<User> getSocialNetworkUserList() {
		return this.socialNetworkUserList;
	}
	public List<Post> getSocialNetworkPostList() {
		return this.socialNetworkPostList;
	}
	public User getActiveUser() {
		return this.activeUser;
	}
	public void setActiveUser(User activeUser) {
		this.activeUser = activeUser;
	}

	// Main.

	public static void main(String[] args) {

		SocialNetwork sn = new SocialNetwork();
		sn.populateNetwork();
		sn.init();

	}

	// Methods.

	private void populateNetwork() {

		// Default users.

		User diego = new User("diego");
		User misa = new User("misa");
		User rosa = new User("rosa");

		this.getSocialNetworkUserList().add(diego);
		this.getSocialNetworkUserList().add(misa);
		this.getSocialNetworkUserList().add(rosa);

		// Default posts.

		PostText diegopost1 = new PostText("Post de texto", "Tareas");
		PostImage misapost1 = new PostImage("Post de imagen", "300x200");
		PostVideo rosapost1 = new PostVideo("Post de Video", "120p", 17);

		diego.addPost(diegopost1);
		rosa.addPost(rosapost1);
		misa.addPost(misapost1);

		this.getSocialNetworkPostList().add(diegopost1);
		this.getSocialNetworkPostList().add(misapost1);
		this.getSocialNetworkPostList().add(rosapost1);

		// Default comments.

		diegopost1.addComment("Cuanto trabajo!", rosa);
		diegopost1.addComment("No paras primo...", misa);
		misapost1.addComment("Tremenda imagen :)", diego);
		rosapost1.addComment("Eres una artista de cuidado", misa);

		// Default friend lists.

		rosa.getFriendList().add(diego);
		rosa.getFriendList().add(misa);
		diego.getFriendList().add(misa);
		misa.getFriendList().add(diego);

	}

	public void init() {

		int opt;

		do {

			System.out.println("\n====================");
			System.out.println("== Social Network ==");
			System.out.println("====================");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("0. Close");

			opt = Utils.integer("\nChoose an option: ");

			switch (opt) {

				case 0:

					System.out.println("Program finished");
					break;

				case 1:

					this.addUser();
					break;

				case 2:

					this.login();
					break;

				default:

					System.out.println("Invalid option");
					break;

			}

		} while (opt != 0);

	}

	private void login() {

		String username = Utils.string("Enter your username: ");

		for (User u : this.getSocialNetworkUserList()) {

			if (username.equals(u.getName())) {

				this.setActiveUser(u);
				break;

			}

		}

		if (this.getActiveUser() != null) {

			this.showLoginOptions();

		} else {

			System.out.println("\n" + "Username does not exist");

		}
	}

	private void showLoginOptions() {

		int opt;

		do {

			System.out.println("\n==================================" + "=".repeat(this.getActiveUser().getName().length()));
			System.out.println("== Social Network. Wellcome, " + this.getActiveUser().getName() + " ==");
			System.out.println("==================================" + "=".repeat(this.getActiveUser().getName().length()));
			System.out.println("1. Add post");
			System.out.println("2. Show my wall");
			System.out.println("3. Show my posts");
			System.out.println("4. Comment on a post");
			System.out.println("5. Show posts from a user");
			System.out.println("6. Show comments from a user");
			System.out.println("7. Manage friends, posts, comments or account");
			System.out.println("0. Go back");

			opt = Utils.integer("\nChoose an option: ");

			switch (opt) {

				case 0:

					System.out.println("Go back");
					this.setActiveUser(null);
					break;

				case 1:

					this.addPost();
					break;

				case 2:

					this.showMyWall();
					break;

				case 3:

					this.showMyPost();
					break;

				case 4:

					this.commentPost();
					break;

				case 5:

					this.showPostFromUsers();
					break;

				case 6:

					this.showCommentFromUsers();
					break;

				case 7:

					this.showManageMenu();
					break;

				default:

					break;
			}

		} while (opt != 0);

	}

	private void showManageMenu() {

		int opt;

		do {

			System.out.println("\n==========================================" + "=".repeat(this.getActiveUser().getName().length()));
			System.out.println("== Social Network Management. Wellcome, " + this.getActiveUser().getName() + " ==");
			System.out.println("==========================================" + "=".repeat(this.getActiveUser().getName().length()));
			System.out.println("1. Show friends");
			System.out.println("2. Add friend");
			System.out.println("3. Delete friend");
			System.out.println("4. Delete post");
			System.out.println("5. Delete comment");
			System.out.println("6. Delete account");
			System.out.println("0. Go back");

			opt = Utils.integer("\nChoose an option: ");

			switch (opt) {

				case 0:

					System.out.println("Go back");
					break;

				case 1:

					System.out.println("Friends list: ");
					Utils.showFromList(this.getActiveUser().getFriendList(), false);
					break;

				case 2:

					this.addFriends();
					break;

				case 3:

					this.deleteFriends();
					break;

				case 4:

					this.deleteMyPost();
					break;

				case 5:

					this.deleteMyComment();
					break;

				case 6:

					this.deleteMyAccount();
					break;

				default:

					System.out.println("Invalid option");
					break;

			}

		} while (opt != 0);

	}

	private void deleteMyAccount() {

		String opt = Utils.string("Are you sure about deleting your account? (Y)es / (N)o: ");

		if (opt.equalsIgnoreCase("y")){

			for (Comment c : this.getActiveUser().getCommentList()) { c.getPost().getCommentList().remove(c); }

			for(Post p : this.getActiveUser().getPostList()) {

				for (Comment c : p.getCommentList()) {

					c.getPost().getCommentList().remove(c);

				}

				this.getSocialNetworkPostList().remove(p);

			}

			this.getActiveUser().getCommentList().clear();
			this.getActiveUser().getPostList().clear();

			for (User u : this.getSocialNetworkUserList()) {

				u.getFriendList().remove(this.getActiveUser());

			}

			this.setActiveUser(null);

			this.init();

		}

	}

	private void deleteMyComment() {

		System.out.println("Indicate the comment you want to delete: ");

		List<Comment> commentList = Utils.showAndSelectFromList(this.getActiveUser().getCommentList(), true);

		if (!commentList.isEmpty()) {

			Comment comment = commentList.get(0);

			comment.getPost().getCommentList().remove(comment);
			this.getActiveUser().getCommentList().remove(comment);

		}

	}

	private void deleteMyPost() {

		System.out.println("Indicate the post you want to delete: ");

		List<Post> postsList = Utils.showAndSelectFromList(this.getActiveUser().getPostList(), true);

		if (!postsList.isEmpty()) {

			Post post = postsList.get(0);

			for (Comment c : post.getCommentList()) {

				c.getUser().getCommentList().remove(c);

			}

			this.getActiveUser().getPostList().remove(post);
			this.getSocialNetworkPostList().remove(post);

		}

	}

	private void deleteFriends() {

		System.out.println("Indicate the friend you want to unfollow: ");

		List<User> userList = Utils.showAndSelectFromList(this.getActiveUser().getFriendList(), true);

		if (!userList.isEmpty()) {

			this.getActiveUser().getFriendList().remove(userList.get(0));

		}

	}


	private void addFriends() {

		List<User> users = this.getActiveUser().friendsSuggestion();

		if (!users.isEmpty()) {

			System.out.println("\n" + "We recommend that you follow one of these users:\n");
			System.out.println(Utils.returnShowFromList(users, false));

		}

		System.out.println("\n" + "App users you don't follow yet: ");

		List<User> friendsAndMe = new ArrayList<>(this.getActiveUser().getFriendList());
		friendsAndMe.add(this.getActiveUser());

		List<User> userList = Utils.showAndSelectFromList(this.getSocialNetworkUserList(), false, false, friendsAndMe);

		if (!userList.isEmpty()) {

			this.getActiveUser().addFriend(userList.get(0));

		}

	}

	private void showCommentFromUsers() {

		List<User> users = Utils.showAndSelectFromList(this.getSocialNetworkUserList(), false);
		Utils.showFromList(users.get(0).getCommentList(), false);

	}

	private void commentPost() {

		int idPost = Utils.integer("\n" + "Enter the ID of the post you want to comment on: ");

		Post p = this.findPostById(idPost);

		if (p != null) {

			System.out.println(p);
			p.addComment(this.getActiveUser());

		}

	}

	private Post findPostById(int idPost) {

		for (Post p : this.getSocialNetworkPostList()) {

			if (p.getPostId() == idPost) {

				return p;

			}

		}

		return null;

	}

	private void showMyWall() {

		List<Post> friendsPostList = new ArrayList<>();

		for (User u : this.getActiveUser().getFriendList()) {

			int numPost = Math.min(u.getPostList().size(), 10);

			for (int i = 0; i < numPost; i++) {

				friendsPostList.add(u.getPostList().get(i));

			}

		}

		Collections.sort(friendsPostList, new ComparatorByDate());

		if (friendsPostList.size() > 10) {

			List<Post> postList = friendsPostList.subList(friendsPostList.size() - 10, friendsPostList.size());
			Collections.reverse(postList);
			Utils.showFromList(postList, false);

		} else {

			Collections.reverse(friendsPostList);
			Utils.showFromList(friendsPostList, false);

		}

	}

	private void showPostFromUsers() {

		List<User> users = Utils.showAndSelectFromList(this.getSocialNetworkUserList(), false);

		Utils.showFromList(users.get(0).getPostList(), false);

        /*
        for (int i = 0; i < this.getSocialNetworkUser().size(); i++) { System.out.println(i+" "+this.getSocialNetworkUser().get(i)); }
        int opt = Utils.integer("Selecciona el numero del usuario: ");
        for (Post p : this.getSocialNetworkUser().get(opt).getPostList()) { System.out.println(p); }
         */

	}

	private void showMyPost() {

		Utils.showFromList(this.getActiveUser().getPostList(), false);

        /*
        for (Post p : this.getActiveUser().getPostList()){ System.out.println(p); }
        */

	}

	private void addPost() {

		int opt = Utils.integer("What type of post do you want to add??:\n1.- Text\n2.- Image\n3.- Video\nChoose an option: ");

		String title = Utils.string("Enter a title: ");

		switch (opt) {

			case 1:

				String content = Utils.string("Enter the content: ");

				PostText textPost = new PostText(title, content);

				this.getActiveUser().addPost(textPost);
				this.getSocialNetworkPostList().add(textPost);
				break;

			case 2:

				String dimension = Utils.string("Enter the dimensions: ");

				PostImage imagePost = new PostImage(title, dimension);

				this.getActiveUser().addPost(imagePost);
				this.getSocialNetworkPostList().add(imagePost);
				break;

			case 3:

				String quality = Utils.string("Enter the quality: ");
				int duration = Utils.integer("Enter the duration (in seconds): ");

				PostVideo videoPost = new PostVideo(title, quality, duration);

				this.getActiveUser().addPost(videoPost);
				this.getSocialNetworkPostList().add(videoPost);
				break;

			default:

				System.out.println("Invalid option");
				break;

		}

	}

	private void addUser() {

		String username = Utils.string("Enter a username: ");

		User user = new User(username);

		this.getSocialNetworkUserList().add(user);

	}

}