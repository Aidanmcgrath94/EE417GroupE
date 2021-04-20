package dao;

import entity.Post;
import entity.User;

public interface PostDao {

	public Post addPost(String author, String subject, String body);
	
	public boolean incrementLikes(int post_id);

	//Post getPost(int id); ??
	
	// Post searchPosts(String searchString);
}
