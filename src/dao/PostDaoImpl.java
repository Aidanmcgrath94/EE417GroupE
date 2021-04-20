package dao;

import entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * post data access object implementation
 */
public class PostDaoImpl implements PostDao{
    /**
     *
     * @param postname
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @return
     */

	@Override
    public Post addPost(String author, String subject, String body) {
        Post post=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection=ConnectionSource.getConnection();
            String sql="INSERT INTO post values (0,?,?,?,now(),0);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,author);
            preparedStatement.setString(2,subject);
            preparedStatement.setString(3,body);
            preparedStatement.execute();
            sql="SELECT LAST_INSERT_ID();";
            statement = connection.createStatement();
            resultSet=statement.executeQuery(sql);
            post=new Post();
            post.setAuthor(author);
            post.setSubject(subject);
            post.setBody(body);
            while (resultSet.next()){
                post.set_id(resultSet.getInt("LAST_INSERT_ID()"));
            }
            sql="SELECT createdDate FROM post WHERE _id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,post.get_id());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                post.setCreatedDate(resultSet.getDate("createdDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try{
                if(connection!=null) connection.close();
                if(preparedStatement!=null) preparedStatement.close();
                if(statement!=null) statement.close();
                if(resultSet!=null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return post;
    }

	@Override
	public boolean incrementLikes(int post_id) {
		// TODO Auto-generated method stub
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
        boolean ret = false;
        try{
        	connection=ConnectionSource.getConnection();	
        	String sql = "UPDATE post SET likes=likes+1 where _id=?";
	 		preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,post_id);
            preparedStatement.execute();  
        	ret = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection!=null) connection.close();
                if(preparedStatement!=null) preparedStatement.close();
                if(statement!=null) statement.close();
                if(resultSet!=null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
	}

	@Override
	public List<Post> searchPosts(String searchString) {
		// TODO Auto-generated method stub
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
		List<Post> posts = new ArrayList<Post>();
		
		 try{
        	connection=ConnectionSource.getConnection();	
        	String sql = "SELECT * FROM post WHERE subject LIKE '%?%' OR body LIKE '%?%'";
	 		preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,searchString);
            preparedStatement.setString(2,searchString);
            preparedStatement.execute();  
            
            while (resultSet.next()) {
	            Post post = new Post();
	            post.set_id(resultSet.getInt("_id"));
	            post.setAuthor(resultSet.getString("author"));
	            post.setSubject(resultSet.getString("subject"));
	            post.setBody(resultSet.getString("body"));
	            post.setCreatedDate(resultSet.getDate("createdDate"));
	            post.setLikes(resultSet.getInt("likes"));
	            posts.add(post);
	        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection!=null) connection.close();
                if(preparedStatement!=null) preparedStatement.close();
                if(statement!=null) statement.close();
                if(resultSet!=null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     	return posts;
		
		
/*
		    try {
		        connection = database.getConnection();
		        statement = connection.prepareStatement("SELECT id, name, value FROM Biler");
		        resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            Biler biler = new Biler();
		            biler.setId(resultSet.getLong("id"));
		            biler.setName(resultSet.getString("name"));
		            biler.setValue(resultSet.getInt("value"));
		            bilers.add(biler);
		        }
		    } finally {
		        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
		        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
		        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
		    }

		    return bilers;
	*/	    
	}
}
