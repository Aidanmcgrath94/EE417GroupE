package dao;

import java.util.List;

import entity.Post;
import entity.User;

public interface PostDao {

	public Post addPost(String author, String subject, String body);
	
	public boolean incrementLikes(int post_id);

	public void clearPosts();
	
	public List<Post> searchPosts(String searchString);
}
