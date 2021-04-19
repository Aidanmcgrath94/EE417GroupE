package dao;

import entity.Post;
import entity.User;

public interface PostDao {

	Post addPost(String author, String subject, String body);

	//Post getPost(int id); ??
	
	// Post searchPosts(String searchString);
}
