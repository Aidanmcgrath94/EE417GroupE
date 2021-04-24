package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Post;

public class engagementDaoImpl implements engagementDao{

	
	
	public List<Post> searchZeroEngagement()
	
	{
		
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
		List<Post> posts = new ArrayList<Post>();
		
		 try{
        	connection=ConnectionSource.getConnection();	
        	String sql = "SELECT * FROM post ";
	 		preparedStatement = connection.prepareStatement(sql);
         
            preparedStatement.execute();  
            
            while (resultSet.next()) {
            	
            	
	            Post post = new Post();
	            
	            int likes = resultSet.getInt("Likes");
	            
	            if(likes==0)
	            {
	            post.set_id(resultSet.getInt("_id"));
	            post.setAuthor(resultSet.getString("author"));
	            post.setSubject(resultSet.getString("subject"));
	            post.setBody(resultSet.getString("body"));
	            post.setCreatedDate(resultSet.getDate("createdDate"));
	            post.setLikes(resultSet.getInt("likes"));
	            posts.add(post);
	            }
	            
	       
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
	}
	
	public List<Post> searchLowEngagement()
	
	{
		
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
		List<Post> posts = new ArrayList<Post>();
		
		 try{
        	connection=ConnectionSource.getConnection();	
        	String sql = "SELECT * FROM post ";
	 		preparedStatement = connection.prepareStatement(sql);
         
            preparedStatement.execute();  
            
            while (resultSet.next()) {
            	
            	
	            Post post = new Post();
	            
	            int likes = resultSet.getInt("Likes");
	            
	            if(likes>0 && likes<=10) 
	            {
	            post.set_id(resultSet.getInt("_id"));
	            post.setAuthor(resultSet.getString("author"));
	            post.setSubject(resultSet.getString("subject"));
	            post.setBody(resultSet.getString("body"));
	            post.setCreatedDate(resultSet.getDate("createdDate"));
	            post.setLikes(resultSet.getInt("likes"));
	            posts.add(post);
	            }
	            
	       
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
	}
	
	
	public List<Post> searchPopular()
	
	{
		
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
		List<Post> posts = new ArrayList<Post>();
		
		 try{
        	connection=ConnectionSource.getConnection();	
        	String sql = "SELECT * FROM post ";
	 		preparedStatement = connection.prepareStatement(sql);
         
            preparedStatement.execute();  
            
            while (resultSet.next()) {
            	
            	
	            Post post = new Post();
	            
	            int likes = resultSet.getInt("Likes");
	            
	            if(likes>10 && likes<=30)
	            {
	            post.set_id(resultSet.getInt("_id"));
	            post.setAuthor(resultSet.getString("author"));
	            post.setSubject(resultSet.getString("subject"));
	            post.setBody(resultSet.getString("body"));
	            post.setCreatedDate(resultSet.getDate("createdDate"));
	            post.setLikes(resultSet.getInt("likes"));
	            posts.add(post);
	            }
	            
	       
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
	}
	
	public List<Post> searchHighEngagement()
	
	{
		
		Connection connection=null;
        PreparedStatement preparedStatement=null;
        Statement statement=null;
        ResultSet resultSet=null;
		List<Post> posts = new ArrayList<Post>();
		
		 try{
        	connection=ConnectionSource.getConnection();	
        	String sql = "SELECT * FROM post ";
	 		preparedStatement = connection.prepareStatement(sql);
         
            preparedStatement.execute();  
            
            while (resultSet.next()) {
            	
            	
	            Post post = new Post();
	            
	            int likes = resultSet.getInt("Likes");
	            
	            if(likes>30)
	            {
	            post.set_id(resultSet.getInt("_id"));
	            post.setAuthor(resultSet.getString("author"));
	            post.setSubject(resultSet.getString("subject"));
	            post.setBody(resultSet.getString("body"));
	            post.setCreatedDate(resultSet.getDate("createdDate"));
	            post.setLikes(resultSet.getInt("likes"));
	            posts.add(post);
	            }
	            
	       
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
	}


}
