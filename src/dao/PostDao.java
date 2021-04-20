package dao;

import entity.Post;
import entity.User;

public interface PostDao {

	Post addPost(String author, String subject, String body);
	
	void incrementLikes(int post_id);

	//Post getPost(int id); ??
	
	// Post searchPosts(String searchString);
}
