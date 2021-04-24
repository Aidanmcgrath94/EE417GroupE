package dao;

import java.util.List;

import entity.Post;

public interface engagementDao {
	
	public List<Post> searchZeroEngagement();
	
	public List<Post> searchLowEngagement();
	
	public List<Post> searchPopular();
	
	public List<Post> searchHighEngagement();
	

}
