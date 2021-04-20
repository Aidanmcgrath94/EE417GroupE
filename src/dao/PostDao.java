package dao;

import java.util.List;

import entity.Post;
import entity.User;

public interface PostDao {

	public Post addPost(String author, String subject, String body);
	
	public boolean incrementLikes(int post_id);

	//Post getPost(int id); ??
	
	public List<Post> searchPosts(String searchString);
}
