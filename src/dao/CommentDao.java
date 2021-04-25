package dao;

import entity.Comment;

public interface CommentDao {
	public Comment addComment(int post_id, String author, String comment);
	public void clearComments();
}
